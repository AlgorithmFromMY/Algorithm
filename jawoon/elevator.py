inputsize=int(input())
input_num = list(input() for _ in range(5))

number = ["####.##.##.####",
          "..#..#..#..#..#",
          "###..#####..###",
          "###..####..####",
          "#.##.####..#..#",
          "####..###..####",
          "####..####.####",
          "###..#..#..#..#",
          "####.#####.####",
          "####.####..####"]

####x##x##x####
####x####XX####

num = ["" for i in range(inputsize)]
result = []
error=0

for inum in input_num:
    for s in range(0,inputsize):
        num[s] += inum[3*s+s:3*(s+1)+s].replace(".","x")

########로직
for i in range(0,len(num)):
    k_set=[]
    for k in range(0,len(number)): 
        correct = 0
        
        for j in range(0,len(num[i])):
            if(num[i][j]=="#" and number[k][j]==num[i][j]):
                correct += 1
                
        if(correct>=num[i].count("#")):    
            k_set.append(str(k))

    if(k_set==[]):
        error+=1
    result.append(k_set)

########결과
if(error>0):
    print(-1)
else:
    while (1):
        if(len(result)==1):
            break
        temp=[]
        for first in result[0]:
            for second in result[1]:
               temp.append(first+second) 
                
        del result[:2]
        result.insert(0,temp)

    result=list(map(int,result[0]))
    sum = 0
    for a in result:
        sum+=a
    print(sum/len(result))




    






    
