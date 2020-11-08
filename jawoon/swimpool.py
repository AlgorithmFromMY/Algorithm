from queue import Queue
import itertools

(n,m)=input().split()

SwimPool = list(list(input()) for _ in range(int(n)))
que = Queue()
SwimPoolflat = list(itertools.chain.from_iterable(SwimPool))
index=SwimPoolflat.index(max(SwimPoolflat))

##startnode = SwimPool.index(max(flattemSwimPool))
start_col = int(index/int(m))
start_row = index%int(m)
startnode = SwimPool[start_col][start_row]
visited=[]
que.put((start_col,start_row))

def BFS(col_row,SwimPool):
    max_dis=0
    (col_tmp,row_tmp)=col_row
    print(col_row)
    thres_row_under= int(row_tmp)-1 if int(row_tmp)-1>=0 else 0
    thres_row_upper= int(row_tmp)+1 if int(row_tmp)+1<int(m) else int(m)-1
    thres_col_under= int(col_tmp)-1 if int(col_tmp)-1>=0 else 0
    thres_col_upper= int(col_tmp)+1 if int(col_tmp)+1<int(n) else int(n)-1

    print("thres_row_under",thres_row_under,"thres_row_upper",thres_row_upper)
    print("thres_col_under",thres_col_under,"thres_col_upper",thres_col_upper)

    cut_swim = SwimPool[thres_col_under:thres_col_upper+1]
    print("cut ",cut_swim)
    cut_swim2=[]
    
    for cut in cut_swim:
        cut_swim2.append(cut[thres_row_under:thres_row_upper+1])

    max_dis = max(list(itertools.chain.from_iterable(cut_swim2)))
    print("cut2 ",cut_swim2)
    print(max_dis)
    for col in range(thres_col_under,thres_col_upper+1):
        for row in range(thres_row_under,thres_row_upper+1):
            print("col",col,"row",row)
            if SwimPool[col][row]==max_dis and visited.count((col,row))==0:
                if col==2 and row==3:
                    print(" debug  ", visited.count((col,row)))
                que.put((col,row))
                print("que.put = col: ",col,"row: ",row)


while(que.qsize()>0):
    
    (col,row) = que.get()
    print("que.get = col: ",col, "row: ",row)
    visited.append((col,row))
    print("visited ",visited)
    BFS((col,row),SwimPool)
##    print("col : ",col,"row : ",row,"SwimPool[][]: ",SwimPool[col][row])





##
##def BFS (row_col,SwimPool):
##    temp=0
##    (row_tmp,col_tmp)=row_col
##    print("row_col",row_col)
##    for col in range(int(col_tmp)-1,int(col_tmp)+2):
##        for row in range(int(row_tmp)-1,int(row_tmp)+2):
##            if col>=0 and col<int(n) and row>=0 and row<int(m):
##                print("pre",row,col)
##            
##                if temp<=int(SwimPool[col][row]) and visited.count((row,col))==0:
##                    temp=int(SwimPool[col][row])
##                    que.put((row,col))
##                    print("que.put = row: ",row,"col: ",col)
##
##








            

