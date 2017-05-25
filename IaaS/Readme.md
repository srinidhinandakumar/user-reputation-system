# Infrastructure as a Service
The Computer Engineering department server was installed with vCloud server. 

Further IaaS implementation was done using virtual machine setup. The golden images used for the setup are Ubuntu 16.04 Deployment
using thin provision and Apple Mac OS X 10.10.


## Virtual Machine details:-
1. Ubuntu 16.04
  – OS type: 64 bit
  – Disk Space: 31.6 GB
  – Memory (RAM): 2.0 GiB
  – Softwares Installed: Sublime Text, GNUSim 8085, Logisim, CodeBlocks,Wireshark, Stress

2. Apple Mac OS X 10.10
  – OS Type: 64 bit
  – Disk space 165 GB
  – CPU 2 core vcpu
  – RAM 4.0/8.0/12.0 GiB
  – Softwares Installed: Sublime Text, GNUSim 8085, Logisim, CodeBlocks,Wireshark, Xcode, Stress
  
  
The setup included assigning a virtual machine to be the server, while deploying the other machines as clients.

>VM on IP 172.16.15.101 was fixed as the server.


All subsequent virtual machines (eg. IP 172.16.15.102, 172.16.15.103… etc) were deployed as the clients. 

The structure includes a total of 30 VMs with Ubuntu OS and 30 VMs with Mac OS.

## Methods to deploy virtual machines on vCloud

### Method 1: We referred to [this](http://docs.trendmicro.com/all/ent/dda/v2.95/en-us/dda_2.95_olh/deploy_create_new_sb.html#id12BCD070W5Z) link 

### Method 2: The procedures followed are as follows:-

1. Vmware->preferences->storage->browse datastore (by right clicking on appropriate datastore)
2. Select and copy the folder (from dialog box just opened) corresponding to the virtual machine created​ beforehand 
3. Create a new folder, name the new virtual machine, and paste there
4. After copy is completed, right click on '.vmx' file and select 'add to inventory'. A new virtual machine will be created in the list
5. Now turn on the virtual machine. A dialog box will appear , choose 'I have copied or moved the virtual machine'

