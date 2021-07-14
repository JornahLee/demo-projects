#! /bin/bash

# start wifi

ip addr set wlp3s0 up && wpa_supplicant -B -i wlp3s0 -c <(wpa_passphrase "xixiwifi" "mimawf614.") && dhclient

nohup /usr/local/share/softwares/frp_0.36.2_linux_amd64/frpc &