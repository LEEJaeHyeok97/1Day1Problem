# N X N
# 적록색약 RG 구분못함
# 적록색약 아닌 사람 구역 수랑 적록색약인 사람 구역 수 출력
from collections import deque

N = int(input())

graph = []

for _ in range(N):
    graph.append(list(input()))

# print(graph)
visited = [[0] * N for _ in range(N)]
# print(visited)

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, color):
    queue = deque([[x, y]])
    visited[x][y] = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] == 0:
                    if graph[nx][ny] == color:
                        visited[nx][ny] = 1
                        queue.append([nx, ny])


ans_li = []
cnt = 0
#적록색약이 아닌 사람이 보는 영역의 갯수
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            color = graph[i][j]
            bfs(i, j, color)
            cnt += 1

# print(cnt)
ans_li.append(cnt)

cnt = 0
# 적록색약인이 보는 영역 갯수
for i in range(N):
    for j in range(N):
        if graph[i][j] == 'R':
            graph[i][j] = 'G'

visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0:
            color = graph[i][j]
            bfs(i, j, color)
            cnt += 1

ans_li.append(cnt)

for i in ans_li:
    print(i, end=" ")