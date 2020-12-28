n = int(input())

Hi = list(map(int,input().split()))
Ai = list(map(int,input().split()))
result =0
count = 0
from queue import PriorityQueue

que = PriorityQueue(maxsize=n)

for i in range(n):
    que.put((Ai[i], Hi[i]))

while not que.empty():
    
    ai,hi = que.get()
    result += ai*count + hi
    count += 1

print(result)

##첫번째 생각했던 코딩인데 왜 안됐는지 생각중
##n = int(input())
##
##Hi = list(map(int,input().split()))
##Ai = list(map(int,input().split()))
##print("Hi",Hi)
##
##expect = Hi[:]
##result = 0
##numbering = [0]*n
##
##for ex_i in range(n):
##    expect[ex_i] += (n-1)*Ai[ex_i]-Hi[ex_i]
##print(expect)
##
##
###i는 몇번째 날에 나무 밸건지, 실제 계산을 위한 수
##for i in range(n):
##    cut_tree_index=expect.index(max(expect))
##    numbering[n-i-1]=cut_tree_index
##    expect[cut_tree_index]=0
####    print("cut_tree_index: ",cut_tree_index)
####    print(expect[cut_tree_index])
####    print("expect : ",expect)
####    print("numbering : ",numbering)
##
##print("Hi",Hi)
##print("Ai",Ai)
##
##
##for j in range(n):
##    
##    result += Hi[numbering[j]] + j*Ai[numbering[j]]
##    print(j)
##    print(result)
##
