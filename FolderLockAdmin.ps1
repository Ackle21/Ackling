param(
    [switch]$RegenerateCode,
    [switch]$ResetAttempts,
    [switch]$ShowState,
    [switch]$DeleteAll
)

$ErrorActionPreference = "Stop"
$root      = Split-Path -Parent $MyInvocation.MyCommand.Path
$stateFile = Join-Path $root "lock_state.json"
$logFile   = Join-Path $root "lock_attempts.csv"

function Get-CodeHash([string]$code) {
    $sha = [System.Security.Cryptography.SHA256]::Create()
    $bytes = [System.Text.Encoding]::UTF8.GetBytes($code)
    $hash = $sha.ComputeHash($bytes)
    return ([System.BitConverter]::ToString($hash) -replace "-", "").ToLower()
}

function Load-State {
    if (Test-Path $stateFile) { return Get-Content $stateFile -Raw | ConvertFrom-Json }
    return $null
}

function Save-State($s) { $s | ConvertTo-Json | Out-File -FilePath $stateFile -Encoding UTF8 }

if ($DeleteAll) {
    Remove-Item $stateFile -ErrorAction SilentlyContinue
    Remove-Item $logFile -ErrorAction SilentlyContinue
    Write-Host "State and log deleted. Next run of FolderLock.ps1 will generate a fresh secret." -ForegroundColor Yellow
    return
}

$state = Load-State

if ($RegenerateCode) {
    if (-not $state) {
        # Bootstrap state if missing
        $state = [pscustomobject]@{
            CodeHash = ""; FailedAttempts = 0; LockoutUntilUtc = $null
            TotalAttempts = 0; LastAttemptUtc = $null; CreatedUtc = [DateTime]::UtcNow.ToString("o")
        }
    }
    $newCode = "{0:D6}" -f (Get-Random -Minimum 100000 -Maximum 1000000)
    $state.CodeHash        = Get-CodeHash $newCode
    $state.FailedAttempts  = 0
    $state.LockoutUntilUtc = $null
    Save-State $state
    Write-Host "New random secret code generated. It is NOT displayed — only the hash is stored." -ForegroundColor Green
    Write-Host "You can still unlock with the backdoor: 022100" -ForegroundColor Magenta
}

if ($ResetAttempts) {
    if ($state) {
        $state.FailedAttempts = 0
        $state.LockoutUntilUtc = $null
        Save-State $state
        Write-Host "Attempts reset and lockout cleared." -ForegroundColor Green
    } else {
        Write-Host "No state file yet — run FolderLock.ps1 first." -ForegroundColor Yellow
    }
}

if ($ShowState) {
    $state = Load-State
    if ($state) {
        Write-Host "=== Lock State ===" -ForegroundColor Cyan
        $state | Format-List
        Write-Host "(Note: CodeHash is SHA-256 of the secret code. The code itself is not recoverable.)" -ForegroundColor Gray
    } else {
        Write-Host "No state file yet — run FolderLock.ps1 first." -ForegroundColor Yellow
    }
    if (Test-Path $logFile) {
        Write-Host "=== Last 10 Log Entries ===" -ForegroundColor Cyan
        Get-Content $logFile -Tail 10 | Format-Table -AutoSize
    }
}

if (-not ($RegenerateCode -or $ResetAttempts -or $ShowState)) {
    Write-Host "Usage:" -ForegroundColor Yellow
    Write-Host "  .\FolderLock-Admin.ps1 -RegenerateCode"
    Write-Host "  .\FolderLock-Admin.ps1 -ResetAttempts"
    Write-Host "  .\FolderLock-Admin.ps1 -ShowState"
    Write-Host "  .\FolderLock-Admin.ps1 -DeleteAll"
}
