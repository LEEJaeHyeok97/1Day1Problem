from collections import deque

M, N, H = map(int, input().split())

graph = [[[0]*M for _ in range(N)] for _ in range(H)]

# print(graph)

queue = deque()

for h in range(H):
    for n in range(N):
        row = list(map(int, input().split()))
        for m in range(M):
            graph[h][n][m] = row[m]
            if row[m] == 1:
                queue.append((h, n, m))


dz = [0, 0, 0, 0, 1, -1]
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]

while queue:
    z, x, y = queue.popleft()
    for i in range(6):
        nz, nx, ny = z + dz[i], x + dx[i], y + dy[i]
        if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M:
            if graph[nz][nx][ny] == 0:
                graph[nz][nx][ny] = graph[z][x][y] + 1
                queue.append((nz, nx, ny))


ans = 0
for h in range(H):
    for n in range(N):
        for m in range(M):
            if graph[h][n][m] == 0:
                print(-1)
                exit()
            ans = max(ans, graph[h][n][m])

print(ans - 1)



