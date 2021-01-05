city_count=int(input())
distance=list(map(int, input().split())) 
spend=list(map(int, input().split())) 
cost=0
j=0

for i in range(len(distance)):
  if spend[i]<spend[j]:                   #비용이 작아지는 주유소를 찾으면 바로 교체!
      j=i
  cost+=spend[j]*distance[i]
print(cost)

