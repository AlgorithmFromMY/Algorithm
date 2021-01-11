// 가장 작은 수 가 젤 앞에 오도록 코드를 짜면 된다.
#include<stdio.h>
#include<stdlib.h>
int compare(const void *a, const void *b)    // 오름차순 비교 함수 구현
{
    int num1 = *(int *)a;    // void 포인터를 int 포인터로 변환한 뒤 역참조하여 값을 가져옴
    int num2 = *(int *)b;    // void 포인터를 int 포인터로 변환한 뒤 역참조하여 값을 가져옴

    if (num1 < num2)    // a가 b보다 작을 때는
        return -1;      // -1 반환
    
    if (num1 > num2)    // a가 b보다 클 때는
        return 1;       // 1 반환
    
    return 0;    // a와 b가 같을 때는 0 반환
}

int main()
{
    int num[1000],i,n,sum=0;
    int j,cnt;

    scanf("%d\n",&n);
    for(i=0;i<n;i++)
        scanf("%d ",&num[i]);
    
    qsort(num, n, sizeof(int), compare);

    for(i=0;i<n;i++)
    {
        cnt=0;
        for(j=0;j<=i;j++)
            cnt=cnt+num[j];
        
        sum=sum+cnt;
    }
    printf("%d",sum);
}