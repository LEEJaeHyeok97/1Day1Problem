import copy
from collections import deque

N = int(input())

graph = []


for i in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

def bfs(x, y, temp_graph):
    queue = deque([(x, y)])
    temp_graph[x][y] = -1
    while queue:
        nx, ny = queue.popleft()

        for i in range(4):
            xx = nx + dx[i]
            yy = ny + dy[i]

            if 0 <= xx < N and 0 <= yy < N:
                if temp_graph[xx][yy] != -1:
                    queue.append((xx, yy))
                    temp_graph[xx][yy] = -1

def set_graph(height, graph):
    for i in range(N):
        for j in range(N):
            if graph[i][j] <= height:
                graph[i][j] = -1

max_value = -10
for i in graph:
    max_value = max(max_value, max(i))

li = []
for h in range(max_value + 1):
    temp_graph = copy.deepcopy(graph)
    set_graph(h, temp_graph)
    cnt = 0
    for i in range(N):
        for j in range(N):
            if temp_graph[i][j] != -1:
                bfs(i, j, temp_graph)
                cnt += 1
    li.append(cnt)

print(max(li))