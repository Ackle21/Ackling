param(
    [int]$LockoutThreshold = 3,
    [int]$LockoutMinutes = 15,
    [switch]$Silent
)

$ErrorActionPreference = "Stop"
$root       = Split-Path -Parent $MyInvocation.MyCommand.Path
$stateFile  = Join-Path $root "lock_state.json"
$secretDir  = Join-Path $root "SecretFolder"
$logFile    = Join-Path $root "lock_attempts.csv"

# ---------- Constants ----------
$BACKDOOR_CODE = "022100"   # Always works - for testing

# ---------- Hashing ----------
function Get-CodeHash([string]$code) {
    $sha = [System.Security.Cryptography.SHA256]::Create()
    $bytes = [System.Text.Encoding]::UTF8.GetBytes($code)
    $hash = $sha.ComputeHash($bytes)
    return ([System.BitConverter]::ToString($hash) -replace "-", "").ToLower()
}

# ---------- State ----------
function New-DefaultState {
    # Generate a fresh random 6-digit code
    $secret = Get-Random -Minimum 100000 -Maximum 1000000
    $secretStr = "{0:D6}" -f $secret

    [pscustomobject]@{
        CodeHash          = (Get-CodeHash $secretStr)
        FailedAttempts    = 0
        LockoutUntilUtc   = $null
        TotalAttempts     = 0
        LastAttemptUtc    = $null
        CreatedUtc        = [DateTime]::UtcNow.ToString("o")
    }
}

function Load-State {
    if (Test-Path $stateFile) {
        try { return Get-Content $stateFile -Raw | ConvertFrom-Json } catch {}
    }
    $s = New-DefaultState
    Save-State $s
    return $s
}

function Save-State($s) {
    $s | ConvertTo-Json | Out-File -FilePath $stateFile -Encoding UTF8
}

function Write-Log($code, $result) {
    if (-not (Test-Path $logFile)) {
        "Timestamp,AttemptedCode,Result,FailedCount,Locked" |
            Out-File -FilePath $logFile -Encoding UTF8
    }
    $state = Load-State
    $locked = if ($state.LockoutUntilUtc -and
                  [DateTime]::Parse($state.LockoutUntilUtc) -gt [DateTime]::UtcNow) { "YES" } else { "no" }
    # Never log the actual code when it's the backdoor or secret — mask it
    $masked = if ($code -eq $BACKDOOR_CODE) { "***BACKDOOR***" } else { $code }
    "$(Get-Date -Format 'o'),$masked,$result,$($state.FailedAttempts),$locked" |
        Out-File -FilePath $logFile -Append -Encoding UTF8
}

# ---------- Lockout ----------
function Get-LockoutRemaining {
    $s = Load-State
    if (-not $s.LockoutUntilUtc) { return [TimeSpan]::Zero }
    $until = [DateTime]::Parse($s.LockoutUntilUtc)
    $remaining = $until - [DateTime]::UtcNow
    if ($remaining.TotalSeconds -gt 0) { return $remaining }
    return [TimeSpan]::Zero
}

function Show-Banner {
    Write-Host ""
    Write-Host "=====================================" -ForegroundColor Cyan
    Write-Host "         SECRET FOLDER LOCK" -ForegroundColor Cyan
    Write-Host "=====================================" -ForegroundColor Cyan
    $remaining = Get-LockoutRemaining
    if ($remaining.TotalSeconds -gt 0) {
        Write-Host ("  LOCKED OUT — try again in {0:N0} min {1:N0} sec" -f `
            [math]::Floor($remaining.TotalMinutes), $remaining.Seconds) -ForegroundColor Red
    } else {
        $s = Load-State
        Write-Host ("  Attempts so far: {0} / {1}" -f $s.FailedAttempts, $LockoutThreshold) -ForegroundColor Yellow
    }
    Write-Host "=====================================" -ForegroundColor Cyan
    Write-Host ""
}

# ---------- Main ----------
if (-not $Silent) { Show-Banner }

# 1) Read input FIRST (before lockout check) so the backdoor can bypass lockout
if ($Silent) {
    $code = [Console]::In.ReadLine()
    if ($null -eq $code) { exit 1 }
    $code = $code.Trim()
} else {
    $code = Read-Host "Enter 6-digit code"
}

# 2) Validate format
if ($code -notmatch '^\d{6}$') {
    Write-Host "Invalid format (must be 6 digits)." -ForegroundColor Red
    Write-Log $code "invalid-format"
    exit 3
}

# 3) BACKDOOR — checked before lockout, before secret code
if ($code -eq $BACKDOOR_CODE) {
    $state = Load-State
    $state.FailedAttempts = 0
    $state.LockoutUntilUtc = $null
    $state.TotalAttempts++
    $state.LastAttemptUtc = [DateTime]::UtcNow.ToString("o")
    Save-State $state
    Write-Log $code "backdoor"
    Write-Host ""
    Write-Host "*** BACKDOOR ACCEPTED — ACCESS GRANTED ***" -ForegroundColor Magenta
    if (Test-Path $secretDir) { Invoke-Item $secretDir }
    exit 0
}

# 4) Lockout check (only for non-backdoor attempts)
$remaining = Get-LockoutRemaining
if ($remaining.TotalSeconds -gt 0) {
    Write-Host ("LOCKED OUT: {0:N0}s remaining" -f $remaining.TotalSeconds) -ForegroundColor Red
    Write-Log $code "blocked-lockout"
    exit 2
}

# 5) Secret-code check
$state = Load-State
$state.TotalAttempts++
$state.LastAttemptUtc = [DateTime]::UtcNow.ToString("o")

if ((Get-CodeHash $code) -eq $state.CodeHash) {
    # SUCCESS
    $state.FailedAttempts = 0
    $state.LockoutUntilUtc = $null
    Save-State $state
    Write-Log $code "success"
    Write-Host ""
    Write-Host "*** ACCESS GRANTED ***" -ForegroundColor Green
    if (Test-Path $secretDir) { Invoke-Item $secretDir }
    exit 0
} else {
    # FAILURE
    $state.FailedAttempts++
    if ($state.FailedAttempts -ge $LockoutThreshold) {
        $state.LockoutUntilUtc = [DateTime]::UtcNow.AddMinutes($LockoutMinutes).ToString("o")
        Write-Host "ACCESS DENIED — LOCKOUT TRIGGERED for $LockoutMinutes minutes." -ForegroundColor Red
        Save-State $state
        Write-Log $code "fail-lockout"
        exit 4
    } else {
        $left = $LockoutThreshold - $state.FailedAttempts
        Write-Host "ACCESS DENIED — $left attempt(s) before lockout." -ForegroundColor Red
        Save-State $state
        Write-Log $code "fail"
        exit 1
    }
}
