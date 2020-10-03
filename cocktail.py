import numpy as np

#prop[0]=p prop[1]=q prop[2]=a prop[3]=b
#처음 들어오는 multi를 곱하고 뒤의 multi로 나누어서 multi에 넣는다

def gcd(a,b):
    result = 1
    for i in range(1,10):
        print("i",i)
        if(a%i==0 and b%i==0):
            a=a/i
            b=b/i
            result=result*i
    return (a,b,a*b*result)

def multiple(multi,divide,standard,target,ingredient):
    if(ingredient[standard]%multi==0):
        (etc1,etc2,gcd)=gcd(ingredient[standard],multi)
        ingredient[target]=ingredient[standard]/(gcd/ingredient[standard])*divide
        return ingredient
    else:
        ingredient=ingredient*multi
        print("multiple ingredient",ingredient)
        ingredient[target]=ingredient[standard]/multi*divide
        return ingredient

def choice(prop,ingredient):
    print("choice_prop",prop)
    if(ingredient[prop[0]]==0 and ingredient[prop[1]]==0):
        print("init")
        ingredient[prop[0]]=prop[2]
        ingredient[prop[1]]=prop[3]
        return ingredient
    elif(ingredient[prop[0]]!=0):
        print("2 target")
        multi=prop[2]
        divide=prop[3]
        standard=prop[0]
        target=prop[1]
        return multiple(multi,divide,standard,target,ingredient)
    elif(ingredient[prop[1]]!=0):
        print("3 target")
        multi=prop[3]
        divide=prop[2]
        standard=prop[1]
        target=prop[0]
        return multiple(multi,divide,standard,target,ingredient)
    else:
        print("error")
        return 0
    
#만약에 비율이
print("재료의 갯수를 입력하시오")
round = int(input())
ingredient = np.array([0 for i in range(round)])
print("ingredient",ingredient)

for i in range(0,round-1):
    print("재료의 번호와 재료의 비율을 입력하시오")
    propinfo = list(map(int,input().split()))
    print("propinfo",propinfo)    
    prop=np.array(propinfo)
    print("prop",prop)
    print("prop2",prop[2],"prop3",prop[3])
    modi_prop1,modi_prop2,etc=gcd(prop[2],prop[3])
    prop[2]=modi_prop1
    prop[3]=modi_prop2
    print("prop",prop)
    ingredient=choice(prop,ingredient)
    print(ingredient)    
