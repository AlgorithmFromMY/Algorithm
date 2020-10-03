#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int check(int);
void prime(int,int);

int arr[1000002];
char p[102];
int i,j;
int flag, wrong;

int main() {

	int k,i;
	scanf("%s %d", p, &k);
	for ( i = 2; i <= k; i++) {
		arr[i] = 1;
	}
	for (i = 2; i < k; i++) {
		if (arr[i] == 1) {
			if (check(i)) {
				flag = 1; break;
			}
			prime(i, k);
		}
	}
	if (flag) { printf("BAD %d", wrong); }
	else {
		printf("GOOD");
	}
	return 0;
}

int check(int n) {
	int ret = 0;
	for (i = 0; i < strlen(p); i++) {
		ret = (ret * 10 + (p[i] - '0')) % n;
	}
	if (ret == 0) { wrong = n; return 1; }
	else { return 0; }
}

void prime(int n, int k) {
	for ( i = n*2; i <= k; i=i+n) {
		if (i % n == 0) { arr[i] = 0; }
	}
}
