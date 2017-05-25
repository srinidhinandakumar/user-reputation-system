# Software as a Service
A basic web application was developed for the client to manage load geenration. 
The primary reason for this was that, there were no real time clients except students and teachers. 
Clients can use stress, infinit loops, and/or launch and use other applications like firefox, sublimetext, etc.
The code to start and stop these services is as follows:-

## Service #1: Infinite Loop
>service1.sh

```
!/bin/bash
uptime

while true
do
	echo "Do something; hit [CTRL+C] to stop!"
done

uptime
```

>service1_stop.sh

```
!/bin/bash
	kill "$(ps -o user=,pid=,stat= -C sh | grep daemon | grep R | cut -b11-15)"
```
##  Service #2: High Stress
> service2.sh

```
uptime
      stress -c 9 -i 7 -m 2 --vm-bytes 512M -t 100s  #time
uptime
```

>service2_stop.sh

```
!/bin/bash
	echo `ps -o user=,pid= -C 'stress  -c 9 -i 7 -m 2 --vm-bytes 512M -t 100s' | grep coed | cut -b11-15`
	
	#sudo pkill stress
```

##  Service #3: Low Stress
> service3.sh

```
uptime
      stress -c 6 -i 4 -m 1 --vm-bytes 256M -t 100s  #time
uptime
```

>service3_stop.sh

```
!/bin/bash
	echo `ps -o user=,pid= -C 'stress  -c 6 -i 4 -m 1 --vm-bytes 256M -t 100s' | grep coed | cut -b11-15`
	
	sudo pkill stress
```

## Service #4: Launch Application
>service4.sh (Sublime Text)

```
/usr/bin/subl %F
```

>service4_stop.sh

```
!/bin/bash

	pkill subl
```
