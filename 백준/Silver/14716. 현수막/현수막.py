M, N = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(M)]

dx = [0, 0, 1, 1, 1, -1, -1, -1]
dy = [1, -1, 0, -1, 1, 0, -1, 1]


def dfs(start_x, start_y):
    st = [(start_x, start_y)]

    while st:
        x, y = st.pop()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if not (0 <= nx < M and 0 <= ny < N):
                continue
            if graph[nx][ny] == 0:
                continue

            graph[nx][ny] = 0
            st.append((nx, ny))



cnt = 0
for i in range(M):
    for j in range(N):
        if graph[i][j] == 1:
            dfs(i, j)
            cnt += 1
print(cnt)
