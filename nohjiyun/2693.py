# 배열 A가 주어졌을 때, 3번째 큰 값을 출력하는 프로그램을 작성하시오.
# 배열 A의 크기는 항상 10이고, 자연수만 가지고 있다. N은 항상 3이다.

A=[10,4,50,30,40,60,30,22,33,44,55];
N = 3;
max = [0,0,0];
mx=A[0];
temp = 0;

for j in range(N):
    for i in A:
        if (i>mx) : mx = i;
    max[j]=mx;
    num = A.index(max[j]);
    del A[num];
    mx = A[0];

print('Thrid max = ',max[2]);
