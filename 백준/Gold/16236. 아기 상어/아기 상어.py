# 아기 상어는 자기보다 큰 물고기는 먹을 수 없고
# 자신보다 작은 물고기만 먹을 수 있다
# 크기가 같으면 먹을 수 없고 지나갈 수만 있다

# 아기 상어 이동 방법
# 더 이상 먹을 수 있는 물고기가 없다면 엄마 상어에게 도움을 요청 -> 종료
# 먹을 수 있는 물고기가 1마리면 그 물고기를 먹으러 간다
# 먹을 수 있는 물고기가 여러마리면 가장 가까운 물고기를 먹으러 간다
# 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때 지나야하는 칸의 개수의 최솟값이다.
# 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러 마리라면 가장 왼쪽에 있는 물고기를 먹는다.

# 아기 상어는 자신과 같은 크기의 물고기를 먹을 때 마다 크기가 1증가한다.

# 아기상어의 처음 크기는 2
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(shark_x, shark_y):
    visited = [[False] * n for _ in range(n)]
    q = deque([])
    q.append((shark_x, shark_y, 0))
    visited[shark_x][shark_y] = True
    fishes = []

    while q:
        x, y, dist = q.popleft()
        # print(x, y, dist)
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if board[nx][ny] <= size:
                    visited[nx][ny] = True
                    if 0 < board[nx][ny] < size:
                        fishes.append((dist + 1, nx, ny))
                    q.append((nx, ny, dist + 1))
    fishes.sort()
    return fishes

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            x, y = i, j
            board[i][j] = 0

size = 2
eat = 0
time = 0


# 시뮬레이션
while True:
    fishes = bfs(x, y)
    if not fishes:
        break

    dist, nx, ny = fishes[0]
    time += dist
    x, y = nx, ny
    board[nx][ny] = 0
    eat += 1

    if eat == size:
        size += 1
        eat = 0

print(time)




