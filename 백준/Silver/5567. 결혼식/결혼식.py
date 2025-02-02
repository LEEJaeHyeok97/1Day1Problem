from collections import deque

n = int(input())
m = int(input())

graph = {}

for i in range(m):
    tmp = input().split()
    if tmp[0] not in graph:
        graph[tmp[0]] = []
    if tmp[1] not in graph:
        graph[tmp[1]] = []
    graph[tmp[0]].append(tmp[1])
    graph[tmp[1]].append(tmp[0])

# print(graph)


def bfs(graph, cur_v):
    visited = set()
    queue = deque([(cur_v, 0)])
    visited.add(cur_v)

    while queue:
        current, dist = queue.popleft()
        if dist == 2:
            continue
        for i in graph[current]:
            if i not in visited:
                visited.add(i)
                queue.append((i, dist + 1))
    return visited
if str(1) not in graph:
    print(0)
else:
    ans = bfs(graph, '1')
    print(len(ans) - 1)






