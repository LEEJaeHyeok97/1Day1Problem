N, M = map(int, input().split())

start_x, start_y, d = map(int, input().split())

graph = [list(map(int, input().split())) for i in range(N)]


# print(graph)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0
while True:
    # 현재 위치 0이면 청소하고 청소 횟수 1증가
    if graph[start_x][start_y] == 0:
        graph[start_x][start_y] = -1
        cnt += 1

    # 2번 4방향 탐색 후 청소 안된 곳 있으면 방향 전환 후 전진
    for i in range(4):
        d = (d - 1) % 4
        nx = start_x + dx[d]
        ny = start_y + dy[d]
        if not (0 <= nx < N and 0 <= ny < M):
            continue
        if graph[nx][ny] == 0:
            start_x = nx
            start_y = ny
            break

    # 4방향 모두 깨끗하고 지금 있는 위치가 청소된 위치면 후진 또는 중단
    else:
        # 후진
        start_x = start_x + dx[d] * (-1)
        start_y = start_y + dy[d] * (-1)
        if not (0 <= start_x < N and 0 <= start_y < M):
            continue
        if graph[start_x][start_y] == 1:
            print(cnt)
            exit()