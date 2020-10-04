from queue import PriorityQueue
from collections import deque

N,D=map(int,input("N,D를 입력하시오 ").split())

print(N,D)

que = PriorityQueue(maxsize=N)

for i in range(0,N):
    start,end,distance=map(int,input("start,end,distance ").split())
    print(start,end,distance)
    ##우선 queue에 들어갈 쓰레기 값부터 정리
    if(end-start<distance or end>D):
        print("discard",distance-(end-start),(start,end,distance))
    else:
        print("work",distance-(end-start),(start,end,distance))
        que.put((distance-(end-start),(start,end,distance)))

##que.get()했을때 크기2의 튜플이고 두번째는 크기3의 튜플이다
deq = deque(maxlen=N)

for i in range(0,que.qsize()):
    if(que.empty()):
        break
    else:
        data=que.get()
        print("data",data)
        if(len(deq)==0):
            print("initial")
            deq.append(data)
        #왼쪽으로 가야 할 때
        elif(data[1][1]<=deq[0][1][0]):
            print("left data :",data[1][0],"deq :",deq[0][1][0])
            deq.appendleft(data)
        #오른쪽으로 가야 할 
        elif(data[1][0]>=deq[-1][1][1]):
            print("right data :",data[1][1],"deq :",deq[-1][1][1])
            deq.append(data)

for i in range(0,len(deq)):
    data = deq.pop()
    print("data : ",data,"i : ",i)
    D=D+data[0]
##    D=D+data[1][2]

print("결과",D)
