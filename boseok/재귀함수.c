#include<stdio.h>
int n=0;
void chat(int c)
{
	int j,i;
	if(c==n)
	{
		for(i=0;i<n;i++)
			printf("____");
		printf("\"����Լ��� ������?\"\n");
		for(i=0;i<n;i++)
			printf("____");
		printf("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");					
	} 

	else
	{
		for(i=0;i<c;i++)
			printf("____");
		printf("\"����Լ��� ������?\"\n");
		for(i=0;i<c;i++)
			printf("____");
		printf("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		for(i=0;i<c;i++)
			printf("____");
		printf("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		for(i=0;i<c;i++)
			printf("____");
		printf("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		chat(c+1);		
	}
	for(i=0;i<c;i++)
		printf("____");
	printf("��� �亯�Ͽ���.\n");	
}

int main()
{
	int count;
	scanf("%d",&count);
	if(count>=1 && count<=50)
	{
		printf("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		n=count;
		chat(0);
	}
}
