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
N = int(input())

graph = [list(map(int, input().split())) for _ in range(N)]

# print(graph)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            shark_x, shark_y = i, j
            graph[i][j] = 0
# print(shark_x, shark_y)
shark_size = 2
eat_count = 0
total_time = 0

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(sx, sy, size):
    visited = [[False]*N for _ in range(N)]
    q = deque([(sx, sy, 0)])
    visited[sx][sy] = True

    candidates = []
    min_dist = None

    while q:
        x, y, dist = q.popleft()

        if min_dist is not None and dist > min_dist:
            break
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if not (0 <= nx < N and 0 <= ny < N):
                continue
            if visited[nx][ny]:
                continue
            if graph[nx][ny] > size:
                continue

            visited[nx][ny] = True
            if 0 < graph[nx][ny] < size:
                if min_dist is None or dist + 1 <= min_dist:
                    min_dist = dist+1
                    candidates.append((dist+1, nx, ny))
            else:
                q.append((nx, ny, dist+1))
    return sorted(candidates, key=lambda x: (x[0], x[1], x[2]))

while True:
    fishes = bfs(shark_x, shark_y, shark_size)
    if not fishes:
        break

    dist, fx, fy = fishes[0]
    total_time += dist
    shark_x, shark_y = fx, fy

    graph[fx][fy] = 0
    eat_count += 1
    if eat_count == shark_size:
        shark_size += 1
        eat_count = 0

print(total_time)
















