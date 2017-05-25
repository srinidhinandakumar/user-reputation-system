!/bin/bash
#uptime

echo `ps -o user=,pid= -C 'stress  -c 9 -i 7 -m 2 --vm-bytes 512M -t 100s' | grep coed | cut -b11-15`

#sudo pkill -9 stress




#uptime
