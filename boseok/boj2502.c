#include <stdio.h>
int a[33];
int b[33];
int c, d;
 
int main() {
	int i,a1,b1;
    a[1] = 1;
    b[2] = 1;
    for (i=3; i<=30; i++) 
	{
        a[i] = a[i-1] + a[i-2];
        b[i] = b[i-1] + b[i-2];
    }
    scanf(" %d %d", &c, &d);
 
    a1 = a[c];
 	b1 = b[c];
    for (i=1; i<=1000000; i++) 
	{
        if ((d - a1 * i) % b1 == 0) 
		{
            printf("%d\n", i);
            printf("%d\n", (d - a1 * i) / b1);
            return 0;
        }
    }
}
