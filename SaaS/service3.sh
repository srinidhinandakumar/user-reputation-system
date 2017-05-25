#!/bin/bash
 
uptime
 stress -c 6 -i 4 -m 1 --vm-bytes 256M -t 100s #time
#stress-ng --cpu 4 --io 2 --vm 1 --vm-bytes 256M --timeout 10s
uptime
