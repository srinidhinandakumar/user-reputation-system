#!/bin/bash
 
 uptime
 stress -c 9 -i 7 -m 2 --vm-bytes 512M -t 100s #time
 uptime
