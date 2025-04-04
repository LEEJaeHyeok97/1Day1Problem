# 천민호 - 이강호
# 천민호 - 최백준
# 최백준 - 김선영
# 김선영 - 김도현
# 김도현 - 민세희

# 1 - 3
# 1 - 4
# 2 - 3
# 3 - 4
# 4 - 5

from collections import defaultdict
from collections import deque

N, M = map(int, input().split())

graph = defaultdict(list)

for i in range(1, N + 1):
    graph[i] = []

for _ in range(M):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

answer = 0

li = [0] * N
def bfs(cur_v, graph, N):
    dist = [-1] * (N+1)
    dist[cur_v] = 0
    queue = deque([cur_v])

    while queue:
        cur_v = queue.popleft()

        for nxt in graph[cur_v]:
            if dist[nxt] == -1:
                dist[nxt] = dist[cur_v] + 1
                queue.append(nxt)
    return dist


li = []
for i in range(1, N+1):
    dist = bfs(i, graph, N)
    sum_dist = sum(dist[1:])
    li.append(sum_dist)

min = min(li)
final_ans = []
for i, v in enumerate(li):
    if v <= min:
        final_ans.append(i)

print(final_ans[0] + 1)






