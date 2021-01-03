from collections import deque

dx=[1,-1,0,0]
dy=[0,0,-1,1]

N=int(input())
house=[list(map(int, input())) for _ in range(N)]
visited=[[0]*N for _ in range(N)]

def bfs(i,j,cnt):
    q=deque()
    visited[i][j]=1 
    cnt+=1 
    q.append([i,j])
    while q:
        y,x=q.popleft()
        for k in range(4):
            ny=y+dy[k]
            nx=x+dx[k]
            if 0<=ny<N and 0<=nx<N:
                if house[ny][nx]==1 and visited[ny][nx]==0:
                    visited[ny][nx]=1
                    house[ny][nx]
                    cnt+=1
                    q.append([ny,nx])
    return cnt
    
each_apartment=[]
group_cnt=0
cnt=0

for i in range(N):
    for j in range(N):
        if house[i][j]== 1 and visited[i][j]==0: 
            cnt=0
            result=bfs(i,j,cnt)
            each_apartment.append(result)
each_apartment.sort()
print(len(each_apartment))
for ans in each_apartment:
    print(ans)
