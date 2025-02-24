from collections import deque

R, C = map(int, input().split())

graph = [list(input()) for _ in range(R)]

# print(graph)


def bfs(x, y):
    queue = deque([(x, y)])


    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < R) and (0 <= ny < C) and graph[nx][ny] == '#':
                graph[nx][ny] = '1'
                queue.append((nx, ny))

cnt = 0
for i in range(R):
    for j in range(C):
        if graph[i][j] == '#':
            bfs(i, j)
            cnt += 1

print(cnt)
# print(graph)