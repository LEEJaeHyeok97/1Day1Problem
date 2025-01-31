from itertools import combinations

N, S = map(int, input().split())

li = list(map(int, input().split()))

cnt = 0
for i in range(1, N + 1):
    tmp = combinations(li, i)

    for i in tmp:
        if sum(i) == S:
            cnt += 1


print(cnt)