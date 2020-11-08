from collections import deque
from sys import stdin

num = int(stdin.readline())
timedomain = [0]*num
for domain_index in range(len(timedomain)):
    a,b=list(map(int, stdin.readline().split()))
    timedomain[domain_index] = (a,b)
##    print(timedomain)
##(a,b)

timedeque = deque(maxlen=num)

time = 0
result = 0

##이후에 (결과값, 인덱스) 덱에 삽입
for numtime in range(num): 
    for timeindex in range(len(timedomain)):
        moment_time=time*timedomain[timeindex][0]+timedomain[timeindex][1]
        time_tuple=(moment_time,timeindex)
        if(len(timedeque)<=0):
            timedeque.append(time_tuple)
##            print ("deque ",timedeque)
        else:
            if(timedeque[0][0]>moment_time):
            ##왼쪽에 삽입
                timedeque.appendleft(time_tuple)
##                print ("deque ",timedeque)
            else:
            ##오른쪽에 삽입
                timedeque.append(time_tuple)
##                print ("deque ",timedeque)

    nextnode=timedeque.popleft()
    time=nextnode[0]
    result+=nextnode[0]
    result%=40000
    del timedomain[nextnode[1]]
    timedeque.clear()

print(result)



