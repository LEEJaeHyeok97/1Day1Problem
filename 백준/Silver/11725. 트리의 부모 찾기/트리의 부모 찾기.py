from collections import deque
from collections import defaultdict

N = int(input())

graph = defaultdict(list)

parents = [0] * (N + 1)

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs():
    queue = deque([1])
    visited = [False] * (N+1)
    visited[1] = True

    while queue:
        cur_v = queue.popleft()
        for i in graph[cur_v]:
            if not visited[i]:
                # visited.append(i)
                # queue.append(i)
                visited[i] = True
                queue.append(i)
                parents[i] = cur_v

bfs()

for i in range(2, N + 1):
    print(parents[i])

