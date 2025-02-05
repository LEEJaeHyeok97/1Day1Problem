N, M = map(int, input().split())

graph = {}

for i in range(1, N + 1):
    graph[i] = []

for _ in range(M):
    a, b = map(int, input().split())
    if b not in graph[a]:
        graph[a].append(b)
    if a not in graph[b]:
        graph[b].append(a)

# print(graph)
def dfs(cur_v, graph, visited):
    visited.append(cur_v)

    for i in graph[cur_v]:
        if i not in visited:
            dfs(i, graph, visited)

    return visited
visited = []
cnt = 0
for i in range(1, N + 1):
    if i not in visited:
        dfs(i, graph, visited)
        cnt += 1
print(cnt)