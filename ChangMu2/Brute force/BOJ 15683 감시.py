#안풀려서 블로그에서 정답 소스코드 가져옴
import sys
import math
from collections import deque
import copy
input=sys.stdin.readline
INF=sys.maxsize

dy=[-1,1,0,0] #서, 동, 북, 남
dx=[0,0,-1,1]
di = [0,[[0],[1],[2],[3]],[[0,1],[2,3]],[[1,2],[1,3],[0,2],[0,3]],[[0,1,2],[0,1,3],[0,2,3],[1,2,3]],[[0,1,2,3]]] #이런 식으로 모든 방향을 이렇게 나타낸거 참신함.

MIN=9999999999999999
def dfs(start,MAP,cctv):
   global MIN
   if start==len(cctv):
      cnt=0
      for y in range(0,row):
         for x in range(0,col):
            if MAP[y][x]==0:
               cnt+=1
      MIN=min(MIN,cnt)
      return

   num,y,x = cctv[start]
   for dir in di[num]:
      tmp = copy.deepcopy(MAP)  #깊은 복사를
      for i in dir: #각 배열의 배열에 접근하여 카운팅 
         ny,nx=y+dy[i],x+dx[i]
         while row>ny>=0 and col>nx>=0:
            if tmp[ny][nx]==6:
               break
            elif tmp[ny][nx]==0:
               tmp[ny][nx]='#'
            ny+=dy[i]
            nx+=dx[i]
      dfs(start+1,tmp,cctv)
   
if __name__ == "__main__":
   row,col=map(int,input().split())
   MAP=[list(map(int,input().split())) for _ in range(row)]
   cctv=[]
   block_cnt=0
   for y in range(0,row):
      for x in range(0,col):
         if MAP[y][x] not in [0,6]:
            cctv.append([MAP[y][x],y,x])
         elif MAP[y][x]==6:
            block_cnt+=1
   dfs(0,MAP,cctv)
   print(MIN)
