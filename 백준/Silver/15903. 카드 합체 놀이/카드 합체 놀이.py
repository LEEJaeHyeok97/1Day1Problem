import copy

n, m = map(int, input().split())

li = list(map(int, input().split()))


for i in range(m):
    li.sort()
    tmp = li[0] + li[1]
    li[0] = tmp
    li[1] = tmp

print(sum(li))