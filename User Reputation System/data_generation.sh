#!/bin/bash
PREV_TOTAL=0
PREV_IDLE=0
MAX=70
MIN=30
x=1
while [ $x -lt 6 ]
do
   	 i=0
   	 while [ $i -lt 50 ] 
    	do
      		# Get the total CPU statistics, discarding the 'cpu ' prefix.
      		CPU=(`sed -n 's/^cpu\s//p' /proc/stat`)
      		
 #memory used percentage sats
      		MEMFREE=(`awk '/MemFree/ { print $2 }' /proc/meminfo`)
      		MEMTOTAL=(`awk '/MemTotal/ { print $2 }' /proc/meminfo`)
      
      		MEMUSED=$((100000*($MEMTOTAL-$MEMFREE)/$MEMTOTAL))
     		 #MEM=$(bc <<< "$MEMTOTAL-$MEMFREE")
      		value=10
     		 #MEM=$(bc << EOF      scale=3       $MEMUSED / (10 ^ 3)       EOF)
      		MEM=(`sed -e "s/[0-9]\{3\}$/.&/" <<< "$MEMUSED"`)
      
IDLE=${CPU[3]} # Just the idle CPU time.
      		
# Calculate the total CPU time.
      		TOTAL=0
      		for VALUE in "${CPU[@]}";
 do
       			 let "TOTAL=$TOTAL+$VALUE"
      		done
# Calculate the CPU usage since we last checked.
     		 let "DIFF_IDLE=$IDLE-$PREV_IDLE"
     		 let "DIFF_TOTAL=$TOTAL-$PREV_TOTAL"
     	 let "DIFF_USAGE=(1000*($DIFF_TOTAL-DIFF_IDLE) / $DIFF_TOTAL + 5 ) /10"
      		
#print details
      		#echo -en "\r$DIFF_USAGE $MEM \n"

# Remember the total and idle CPU times for the next check.
      		PREV_TOTAL="$TOTAL"
      		PREV_IDLE="$IDLE"
 # Wait before checking again.

		y="$(ifconfig | grep -A 1 'ens32' | tail -1 | cut -d ':' -f 2 | cut -d ' ' -f 1 | cut -b 12-14)"
echo -en "$DIFF_USAGE $MEM \n" >> "vm_`expr $y`` expr $x`.txt"
      		sleep 1
		#echo "i= $i"
		i=`expr $i + 1`
    	done
	echo "File $x generated"
	x=`expr $x + 1`	
done
