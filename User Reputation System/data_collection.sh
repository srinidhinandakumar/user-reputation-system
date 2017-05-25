#!/bin/bash
#copy files from Client Virtual Machine at IP 172.16.15.130
sshpass –p********* ssh coed@172.16.15.130 "cd Desktop/data_collection/VM && ./client_script.sh && scp -i ~/.ssh/id_rsa ~/Desktop/data_collection/VM/vm_*.txt coed@172.16.15.101:/home/coed/Desktop/server/"
echo "Files copied"
