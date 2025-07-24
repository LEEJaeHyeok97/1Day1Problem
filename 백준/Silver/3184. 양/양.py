# o: 양, v: 늑대, #: 울타리, .: 빈 공간

R, C = map(int, input().split())

graph = [list(input()) for _ in range(R)]

# print(graph)

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

def dfs(cur_x, cur_y, sheep, wolf):
    st = [(cur_x, cur_y)]
    graph[cur_x][cur_y] = '-'
    while st:
        x, y = st.pop()
        # print(x, y)
        # print(graph[x][y])


        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if not (0 <= nx < R and 0 <= ny < C):
                continue
            if graph[nx][ny] == '#':
                continue
            if graph[nx][ny] == '-':
                continue
            if graph[nx][ny] == 'v':
                wolf += 1
            if graph[nx][ny] == 'o':
                sheep += 1

            graph[nx][ny] = '-'
            st.append((nx, ny))

    # print([sheep, wolf])
    if sheep > wolf:
        return [sheep, 0]
    else:
        return [0, wolf]


# print(dfs(1, 1))


total_sheep = 0
total_wolf = 0
for i in range(R):
    for j in range(C):
        if graph[i][j] == '.':
            a, b = dfs(i, j, 0, 0)
            total_sheep += a
            total_wolf += b
        elif graph[i][j] == 'v':
            a, b = dfs(i, j, 0, 1)
            total_sheep += a
            total_wolf += b
        elif graph[i][j] == 'o':
            a, b = dfs(i, j, 1, 0)
            total_sheep += a
            total_wolf += b

print(total_sheep, total_wolf)


