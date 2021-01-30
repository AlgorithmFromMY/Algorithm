#BOJ 1926 최소비용 구하기 (다익스트라)
import sys, heapq
input=sys.stdin.readline

INF = sys.maxsize
N=int(input())
M=int(input())

graph=[[ ] for _ in range(N+1)]
distance=[INF]*(N+1)

for i in range(M):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))

start,end=map(int, input().split())

def dijkstra(start):
    heap=[]
    distance[start]=0
    heapq.heappush(heap,(0, start))
    while heap:
        dist,cur=heapq.heappop(heap)
        if dist > distance[cur]: #새로 꺼낸 것의 길이가 기존 거리보다 길어 버리면 바꿀 필요가 없으니 방문한걸로!
            continue
        for i in graph[cur]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(heap,(cost, i[0]))
                
dijkstra(start)
print(distance[end])
