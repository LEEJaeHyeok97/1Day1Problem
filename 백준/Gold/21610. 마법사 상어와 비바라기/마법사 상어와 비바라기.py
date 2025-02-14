N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

d_move = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
dx = [-1, -1, 1, 1]
dy = [-1, 1, -1, 1]

wizard = [list(map(int, input().split())) for _ in range(M)]

goorm = {(N, 1), (N, 2), (N - 1, 1), (N - 1, 2)}

flag = 0
for d, s in wizard:
    a, b = d_move[d - 1]

    # 1. 구름 이동 (모듈러 연산)
    new_goorm = set()
    for x, y in goorm:
        new_x = (x - 1 + a * s) % N + 1
        new_y = (y - 1 + b * s) % N + 1
        new_goorm.add((new_x, new_y))
    goorm = new_goorm

    # 2. 각 구름이 있는 칸에 비 내리기
    for i in goorm:
        graph[i[0] - 1][i[1] - 1] += 1

    # 3. 물 복사 버그
    for i in goorm:
        cnt = 0
        for k in range(4):
            x = dx[k] + i[0]
            y = dy[k] + i[1]
            if 1 <= x <= N and 1 <= y <= N:
                if graph[x - 1][y - 1] > 0:
                    cnt += 1
        graph[i[0] - 1][i[1] - 1] += cnt

    # 4. 새 구름 생성 (이전에 구름이 있었던 칸 제외)
    next_goorm = set()
    for i in range(N):
        for j in range(N):
            if (i + 1, j + 1) not in goorm:
                if graph[i][j] >= 2:
                    graph[i][j] -= 2
                    next_goorm.add((i + 1, j + 1))

    if flag == len(wizard) - 1:
        ans = sum(sum(row) for row in graph)
        print(ans)
    goorm = next_goorm   # ← 여기서 next_goorm으로 갱신해야 함
    flag += 1
