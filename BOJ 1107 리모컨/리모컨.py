#1107 리모컨  
#그냥 모든 경우의 수를 계산해서 구현하는 문제라 좋은 문제는 아닌거 같음..
input = sys.stdin.readline 

n = int(input())
list_n = list(str(n))
m = int(input())
a = [1 for _ in range(10)]

if m != 0:
    broken = list(map(int, input().split()))
    for i in broken:
        a[i] = 0

cnt = abs(n - 100)
for i in range(1000001):
    list_i = list(str(i))
    flag = 0
    for c in list_i:
        if a[int(c)] == 1:
            continue
        else:
            flag = 1
            break

    if flag:
        continue
    else:
        cnt = min(cnt, abs(n - i) + len(list_i))

print(cnt)
