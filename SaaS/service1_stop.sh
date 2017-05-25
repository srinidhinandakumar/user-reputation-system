!/bin/bash
#printf "\n\n before: "
#uptime
#gcc loop.c
#./a.out
#printf "\n\n after: "
#echo "hi"
	kill "$(ps -o user=,pid=,stat= -C sh | grep daemon | grep R | cut -b11-15)"
	#echo "hello"
#echo $pid
#kill $pid

#sudo pkill sh




#uptime
#print "Execution"
