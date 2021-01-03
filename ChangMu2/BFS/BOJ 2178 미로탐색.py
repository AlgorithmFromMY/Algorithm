from collections import deque

dx=[1,-1,0,0]
dy=[0,0,-1,1]

def bfs(road, N, M):
    visited=[[False]*M for _ in range(N)]
    dist=[[0]*M for _ in range(N)] #최단 경로를 파악하기 위한 배열 
    dist[0][0]=1 #조건에서 시작점은 1의 거리 값을 가지는 것으로 주어짐
    q=deque()
    q.append([0,0])
    
    cnt=0
    while q:
        y, x=q.popleft()
        for i in range(4):
            ny=y+dy[i]
            nx=x+dx[i]
            if 0<=ny<N and 0<=nx<M:
                if visited[ny][nx]!=True and road[ny][nx]==1:
                    visited[ny][nx]=True #방문처리
                    q.append([ny,nx])
                    dist[ny][nx]=dist[y][x]+1 #핵심 코드
    print(dist[N-1][M-1])    
                    
N,M=map(int, input().split())
road=[list(map(int, input())) for _ in range(N)]
bfs(road,N,M)
