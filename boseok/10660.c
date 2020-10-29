#include<stdio.h>
int ch[1024][1024]={0};
int sumch(int x, int x1, int y, int y1)
{
	int sum;
	
	if(x!=0 && x1!=0 && y!=0 && y1!=0)
		sum=ch[y][y1]-ch[x-1][y1]-ch[y][x1-1]+ch[x-1][x1-1];
	
	else if(x==0 || x1==0)
	{
		if(x==0&&x1==0)
			sum=ch[y][y1];
		else if(x==0)
			sum=ch[y][y1]-ch[y][x1-1];
		else
			sum=ch[y][y1]-ch[x-1][y1];
	}
	
	return sum;
}
int main()
{
	int m,n,i,j,a;
	int b,c,d,res[100001]={0};
	
	scanf("%d %d",&n,&m);
	
	for(i=0;i<n;i++)
	{
		if(i!=0)
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",&a);
							
				if(j==0)
					ch[i][j]=a+ch[i-1][j];
				else
					ch[i][j]=a+ch[i-1][j]+ch[i][j-1]-ch[i-1][j-1];
			}
		}
		else
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",&a);
								
				if(j==0)
					ch[i][j]=a;
				else
					ch[i][j]=a+ch[i][j-1];
			}
		}
		
	}
	
	for(i=0;i<m;i++)
	{
		scanf("%d %d %d %d",&a,&b,&c,&d);
		res[i]=sumch(a-1,b-1,c-1,d-1);
	}
	for(i=0;i<m;i++)
		printf("%d\n",res[i]);
	return 0;
}
