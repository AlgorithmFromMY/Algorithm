#BOJ11478  서로 다른 부분 문자열의 개수

str_list= input( )
lenth=len(str_list)
string_list= []

for i in range(0,lenth):
  for j in range(i+1,lenth+1):
    string_list.append(str_list[i:j])
string_set=set(string_list)  #set을 통해서 중복 되는 부분 문자열 삭제
print(len(string_set))