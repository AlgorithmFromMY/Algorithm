from itertools import combinations
s=input()

left=[]
list_tuple = []
for char_index in range(len(s)):
    if s[char_index] == "(":left.append(char_index) 
    elif s[char_index] == ")":list_tuple.append([left.pop(),char_index])

result = []
tmp_result=[]

for combi_num in range(1,len(list_tuple)+1) :
    tmp_result = list(map(lambda x:list(x),combinations(list_tuple,combi_num)))
    result = result + tmp_result

out = set()
for i in result:
    tmp_s=list(s)
    for index in i:
        
        tmp_s[index[0]]=" "
        tmp_s[index[1]]=" "
    tmp_s=''.join(tmp_s)
    out.add(tmp_s.replace(" ",""))

for i in sorted(out):print(i)

