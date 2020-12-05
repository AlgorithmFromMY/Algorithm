import sys, collections
input = sys.stdin

def DFS(start_node,relation):

    if not relation[start_node]:
        count[start_node]=0
        return
    
    visited = [False for _ in range(n+1)]
    stack = [start_node]
    count_node = 1
    
    while(stack):
        visited_node=stack.pop()
        visited[visited_node]=True

        for visited_node in relation[visited_node]:
            if not visited[visited_node]:
                stack.append(visited_node)
                count_node += 1
                
    count[start_node]=count_node
    
n, m = map(int,input.readline().split())

count= [ 0 for _ in range(n+1)]
relation = [[] for _ in range(n+1)]

for _ in range(m):
    child,parent  = map(int,input.readline().split())
    relation[parent].append(child)


for node in range(1,n+1):
    DFS(node,relation)

max_count=max(count)
for compare in range(len(count)):
    if count[compare] == max_count:
        print(compare, end = ' ')
