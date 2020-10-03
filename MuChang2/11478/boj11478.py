str_list= input( )
lenth=len(str_list)
string_list= []

for i in range(0,lenth):
for j in range(i+1,lenth+1):
string_list.append(str_list[i:j])
string_set=set(string_list)  #set( ) 통해서 중복되는 문자열 리스트에서 제거
print(len(string_set))
