#include <stdio.h>
#include <stdlib.h>

int dfs(int net[][2],int c,int h)
{
    int visit[101]={0}, i ,stack[101]={0}, cnt=0;

    stack[0]=1; visit[0]=1;

    while(stack[0]!=0)
    {
        for(i=0;i<h;i++)
        {
            if(net[i][0]==stack[cnt])
            {
                if(visit[net[i][1]-1]!=1)
                {
                    cnt++;
                    stack[cnt]=net[i][1];
                    visit[stack[cnt]-1]=1;
                    break;
                }
            }
            else if(net[i][1]==stack[cnt])
            {
                if(visit[net[i][0]-1]!=1)
                {
                    cnt++;
                    stack[cnt]=net[i][0];
                    visit[stack[cnt]-1]=1;
                    break;
                }
            }
        }
        if(i==h)
        {
            if(cnt==0)
                stack[cnt]=0;
            else
            {
                stack[cnt]=0;
                cnt--;
            }
        }
    }
    for(i=0;i<c;i++)
    {
        if(visit[i]==1)
            cnt++;
    }
    return cnt;
}
int main()
{
    int com, head, i;
    int netw[5000][2];

    scanf("%d",&com);
    scanf("%d",&head);

    for(i=0;i<head;i++)
    {
        scanf("%d %d",&netw[i][0],&netw[i][1]);
    }

    printf("%d",dfs(netw, com, head)-1);
    return 0;
}
