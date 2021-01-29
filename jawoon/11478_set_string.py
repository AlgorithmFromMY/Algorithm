s = input()

set_index=0

s_before_set=['']*int(len(s)*(len(s)+1)/2)
##print(s_before_set)

for loop in range(0,len(s)):
    for s_index in range(0,(len(s)-loop)):
        s_before_set[set_index ]=s[s_index:(s_index+loop+1)]
##        print(s_before_set)
        set_index=set_index+1

s_set = set(s_before_set)
##print(s_set)
print(len(s_set))

