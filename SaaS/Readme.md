# Software as a Service
A basic web application was developed for the client to manage load geenration. 
The primary reason for this was that, there were no real time clients except students and teachers. 
Clients can use stress, infinit loops, and/or launch and use other applications like firefox, sublimetext, etc.
The code to start and stop these services is as follows:-

##  Service #1: High Stress
> service1.sh
```
uptime
      stress -c 9 -i 7 -m 2 --vm-bytes 512M -t 100s#time
```
