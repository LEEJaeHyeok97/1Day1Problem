# N개의 강의
# 강의 시간표가 주어질 때, 밖에 나오는 것을 최소화하여 최소 몇 번만 나오면 되는지 구해보자.
# 맨 처음 강의를 들으러 이동하는 횟수는 세지 않는다.
def find(x):
    if buildings[x] != x:
        buildings[x] = find(buildings[x])
    return buildings[x]
def union(a, b):
    x = find(a)
    y = find(b)
    if x != y:
        buildings[y] = x

N, M = map(int, input().split())

buildings = [i for i in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())

    union(a, b)

queries = list(map(int, input().split()))
cnt = 0
for i in range(len(queries) -1):
    a = find(queries[i])
    b = find(queries[i+1])
    if a == b:
        continue
    else:
        cnt += 1
print(cnt)