# 트리는 사이클이 없는 무방향 그래프
# 두 노드 사이의 경로가 항상 하나만 존재
# 두 노드를 쫙 당겼을때 길이가 가장 길 때 = 트리의 지름
# 노드 n <= 10000
import sys
from collections import defaultdict
sys.setrecursionlimit(10**7)

n = int(input())

graph = defaultdict(list)

for i in range(n - 1):
    v1, v2, weight = map(int, input().split())
    graph[v1].append([v2, weight])
    graph[v2].append([v1, weight])


def dfs(node, dist):
    visited[node] = dist
    for nxt, w in graph[node]:
        if visited[nxt] == -1:
            dfs(nxt, dist + w)


visited = [-1] * (n+1)
dfs(1, 0)

max_node = 1
max_dist = 0
for i in range(1, n + 1):
    if visited[i] > max_dist:
        max_dist = visited[i]
        max_node = i

visited = [-1] * (n+1)
dfs(max_node, 0)

d = max(visited)
print(d)

