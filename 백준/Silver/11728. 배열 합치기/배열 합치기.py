N, M = map(int, input().split())

A = list(map(int, input().split()))
B = list(map(int, input().split()))


A.extend(B)

A.sort()

for i in A:
    print(i, end=' ')