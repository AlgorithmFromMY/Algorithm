// 처음에는 c의 suffix array 이용하여 문제를 풀려고 하였음
// 문자열 배열을 이용하여 strcmp를 이용하여 문제를 풀려고 시도함
// suffix array(접미사배열) : 문자열s의 모든 접미사를 사전 순으로 정렬해 놓은 배열
// 이 배열을 이용하여 같은 문자는 제외하는 식으로 문제를 풀려고 시도했으나 너무 복잡한 코드가 나올 것이라고 생각함
// 구글링을 통해서 파이썬으로 하는 방법을 공부함.
// 앞으로 c로 어려워보이는 알고리즘은 파이썬으로 작성해보려고 함.

string = str(input()) 
strings = []

for i in range(len(string)): ]
  for j in range(len(string) - i): 
    strings.append(string[j:j+i+1]) 
    
print(len(set(strings)))
