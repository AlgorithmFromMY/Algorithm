Test_Case=int(input())

sum1=0
sum2=0
i=0
for i in range(Test_Case):
    new_num=(input())
    sum1=0
    sum2=0
    for i in range(0,16,2): #짝수
        if int(new_num[i])*2>=10:
            ans=int(new_num[i])*2
            sum1+=ans//10+ans%10
        else:
            ans=int(new_num[i])*2
            sum1+=ans
    for i in range(1,17,2):  #홀수
        ans=int(new_num[i])
        sum2+=ans
    result=sum1+sum2
    if result%10 == 0:
        print("T")
    else:
        print("F")
    
        
        
    
        
        

  
        
        
        
        


        

