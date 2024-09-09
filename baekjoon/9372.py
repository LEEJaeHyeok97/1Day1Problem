# graph = {
#     'A': ['B', 'D', 'E'],
#     'B': ['A', 'C', 'D'],
#     'C': ['B'],
#     'D': ['A', 'B'],
#     'E': ['A']
# }
#
# def dfs(graph, cur_v, visited=[]):
#     visited.append(cur_v)
#     for v in graph[cur_v]:
#         if v not in visited:
#             visited = dfs(graph, v, visited)
#     return visited
#
# print(dfs(graph, 'A'))

T = int(input())

def dfs(graph, cur_v, visited = ()):
    visited.add(cur_v)
    for i in graph[cur_v]:
        if i not in visited:
            visited = dfs(graph, i, visited)
    return visited


for _ in range(T):
    N, M = map(int, input().split())
    graph = {}

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

    visited = set()

    print(len(dfs(graph, 1, visited)) - 1)
