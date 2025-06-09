R, C, K = map(int, input().split())

# print(K)
# print(R)
# print(C)

graph = []
for _ in range(R):
    graph.append(list(input()))


dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

ans = 0
def dfs(x, y, distance):
    global ans

    if distance == K and y == C - 1 and x == 0:
        ans += 1
    else:
        graph[x][y] = 'T'
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C and graph[nx][ny] == '.':
                graph[nx][ny] = 'T'
                dfs(nx, ny, distance + 1)
                graph[nx][ny] = '.'

dfs(R-1, 0, 1)

print(ans)