import sys, heapq

INF=sys.maxsize
input=sys.stdin.readline

N,M,X=map(int, input().split())
town=[]
for i in range(N+1):
    town.append(i) #0, 1, 2, 3, 4
graph=[[ ] for _ in range(M+1)]
distance=[INF]*(N+1)
for _ in range(M):
    a,b,c=map(int, input().split())
    graph[a].append((b,c))

def dijstra(start, target): #일반적인 다익스트라 알고리즘 코드
    heap=[]
    heapq.heappush(heap,(0,start))
    for i in range(len(distance)): #distance값 초기화!
        distance[i]=INF
    distance[start]=0
    while heap:
        dist, cur=heapq.heappop(heap)
        if dist > distance[cur]:
            continue
        for i in graph[cur]: #인접노드 확인 
            cost=dist+i[1] 
            if cost < distance[i[0]]: #새로운 거리(=cost)가 더 짧으면 갱신
                distance[i[0]]=cost
                heapq.heappush(heap,(cost,i[0]))
    return distance[target]
            
target=X #목적지 ex)문제에서는 X=2
to_town=[ ] # X에서 다시 되돌아오는 각각 경로의 최소값을 담는 배열
to_target=[ ] # X가 아닌 곳들에서 X(=taget)로 가는 각각 경로의 최소값을 담는 배열
answer=[ ] # to_town + to_target = 각각의 경로가 X에 갔다가 다시 되돌아 올 경우 즉, '왕복'했을 때 각각 경로의 최소값을 담은 배열
for i in range(1,N+1):
    start=town[i]
    result=dijstra(start, target)
    if start==target:
        for j in range(1,N+1):
            if j==target:
                continue
            to_town.append(distance[j])
    else:
        to_target.append(distance[target])

for i in range(N-1):
    ans=to_town[i]+to_target[i]
    answer.append(ans)
print(max(answer))
