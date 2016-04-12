$m = New-Object -ComObject HNetCfg.HNetShare
$c = $m.EnumEveryConnection |? { $m.NetConnectionProps.Invoke($_).Name -eq "Ethernet" }
$config = $m.INetSharingConfigurationForINetConnection.Invoke($c)
$config.EnableSharing(0)