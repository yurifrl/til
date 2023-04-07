function Install-Executable($url, $output) {
  Invoke-WebRequest -Uri $url -OutFile $output
  Start-Process -FilePath $output -Wait
}

# Install Parsec
$installParsec = Read-Host -Prompt 'Do you want to install Parsec? (y/n)'
if ($installParsec -eq 'y') {
  Install-Executable -url "https://builds.parsec.app/package/parsec-windows.exe" -output "parsec-windows.exe"
}

# Install Nvidia driver
$installNvidia = Read-Host -Prompt 'Do you want to install the Nvidia driver? (y/n)'
if ($installNvidia -eq 'y') {
  Install-Executable -url "https://download.microsoft.com/download/f/a/f/fafa2972-4975-482e-99e6-442d5ad864a1/528.24_grid_win10_win11_server2019_server2022_dch_64bit_international-Azure-swl.exe" -output "nvidia-driver.exe"
}

# Install Virtual Audio Cable
$installVAC = Read-Host -Prompt 'Do you want to install Virtual Audio Cable? (y/n)'
if ($installVAC -eq 'y') {
  Install-Executable -url "https://software.muzychenko.net/trials/vac467.exe" -output "vac467.exe"
}

# Install Star Citizen
$installStarCitizen = Read-Host -Prompt 'Do you want to install Star Citizen? (y/n)'
if ($installStarCitizen -eq 'y') {
  Install-Executable -url "https://install.robertsspaceindustries.com/star-citizen/RSI-Setup-1.6.5.exe" -output "RSI-Setup-1.6.5.exe"
}

# Modify the 'Winlogon' registry key
$modifyWinlogon = Read-Host -Prompt 'Do you want to modify the Winlogon registry key? (y/n)'
if ($modifyWinlogon -eq 'y') {
  $WinlogonPath = "HKLM:\SOFTWARE\Microsoft\Windows NT\CurrentVersion\Winlogon"
  $WinlogonPropertyName = "YourPropertyName" # Replace with the actual property name
  $WinlogonPropertyValue = "YourValue" # Replace with the actual value you want to set
  Set-ItemProperty -Path $WinlogonPath -Name $WinlogonPropertyName -Value $WinlogonPropertyValue
}

# Modify the 'Personalization' registry key
$modifyPersonalization = Read-Host -Prompt 'Do you want to modify the Personalization registry key? (y/n)'
if ($modifyPersonalization -eq 'y') {
  $PersonalizationPath = "HKLM:\SOFTWARE\Policies\Microsoft\Windows\Personalization"
  $PersonalizationPropertyName = "YourPropertyName" # Replace with the actual property name
  $PersonalizationPropertyValue = "YourValue" # Replace with the actual value you want to set
  Set-ItemProperty -Path $PersonalizationPath -Name $PersonalizationPropertyName -Value $PersonalizationPropertyValue
}