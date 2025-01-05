N, M, V = map(int, input().split())

graph = {i: [] for i in range(1, N + 1)}


def dfs(graph, cur_v, visited=[]):
    visited.append(cur_v)
    for i in graph[cur_v]:
        if i not in visited:
            dfs(graph, i, visited)
    return visited

def bfs(graph, cur_v, visited=[]):
    need_visited = []

    need_visited.append(cur_v)

    while need_visited:
        pop = need_visited.pop(0)
        if pop not in visited:
            visited.append(pop)
            need_visited.extend(graph[pop])

    return visited


for i in range(M):
    a, b = map(int, input().split())

    if a not in graph:
        graph[a] = [b]
    else:
        graph[a].append(b)
    if b not in graph:
        graph[b] = [a]
    else:
        graph[b].append(a)

for key in graph:
    graph[key].sort()



for i in dfs(graph, V):
    print(i, end=' ')
print()
for i in bfs(graph, V):
    print(i, end=' ')