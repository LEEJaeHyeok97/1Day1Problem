N, M = map(int, input().split())

graph = list([0] * (N + 1) for _ in range(N + 1))
ans = 0


def dfs(start, end, dist):
    global ans
    visited[start] = 1
    for i in range(1, N + 1):
        if graph[start][i] > 0 and not visited[i]:
            if i == end:
                ans = dist + graph[start][i]
            else:
                dfs(i, end, dist + graph[start][i])




for i in range(N - 1):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

count = 0
while count < M:
    a, b = map(int, input().split())
    visited = [0] * (N + 1)
    dfs(a, b, 0)
    print(ans)
    count += 1
