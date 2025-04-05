# 섬의 개수를 센다

# 1은 땅 0은 바다
# 입력 마지막에는 0 0이 주어진다

import sys

sys.setrecursionlimit(10 ** 6)

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]


def dfs(x, y):
    visited[x][y] = True
    for i in range(8):
        nx = dx[i] + x
        ny = dy[i] + y

        if 0 <= nx < h and 0 <= ny < w:
            if not visited[nx][ny] and graph[nx][ny] == 1:
                dfs(nx, ny)


while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break

    graph = []
    for _ in range(h):
        graph.append(list(map(int, sys.stdin.readline().split())))

    visited = [[False] * w for _ in range(h)]

    cnt_island = 0
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1 and not visited[i][j]:
                dfs(i, j)
                cnt_island += 1

    print(cnt_island)
