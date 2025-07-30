# from collections import deque
# from collections import defaultdict
#
# N = int(input())
#
# graph = defaultdict(list)
#
# parents = [0] * (N + 1)
#
# for _ in range(N - 1):
#     a, b = map(int, input().split())
#     graph[a].append(b)
#     graph[b].append(a)
#
#
# def bfs():
#     queue = deque([1])
#     visited = [False] * (N+1)
#     visited[1] = True
#
#     while queue:
#         cur_v = queue.popleft()
#         for i in graph[cur_v]:
#             if not visited[i]:
#                 # visited.append(i)
#                 # queue.append(i)
#                 visited[i] = True
#                 queue.append(i)
#                 parents[i] = cur_v
#
# bfs()
#
# for i in range(2, N + 1):
#     print(parents[i])
#





# 공기 청정기는 항상 2 행을 차지한다.
# 1. 미세먼지는 확산된다.
# 미세먼지는 인접한 네 방향으로 확산된다.
# 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
# 확산되는 양은 A/5이고 소수점은 버린다.

# 2. 공기청정기가 작동한다
# 바람이 불면 미세먼지가 바람의 방향으로 모두 한칸씩 이동한다
# 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.

# 0 30 7
# 0 10 0
# 0 0 20

# 6 15 11
# 공 10 7
# 청 6 12

# 공기 청정기는 항상 0번 열에 있음(문제 상 1열)
# 1초 간 진행 순서 1. 미세먼지 확산 -> 2. 공기청정기 작동

from copy import deepcopy
R, C, T = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(R)]

# print(graph)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def spread():
    tmp_graph = [[0] * C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            cnt = 0
            if graph[i][j] >= 5:
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]

                    if not (0 <= nx < R and 0 <= ny < C):
                        continue
                    if graph[nx][ny] == -1:
                        continue
                    tmp_graph[nx][ny] += graph[i][j] // 5
                    cnt += 1
                tmp_graph[i][j] -= (graph[i][j] // 5) * cnt
    for i in range(R):
        for j in range(C):
            graph[i][j] += tmp_graph[i][j]
    return graph

def clean_machine():
    upper = lower = None
    for i in range(R):
        if graph[i][0] == -1:
            if upper is None:
                upper = i
            else:
                lower = i

    up_path = []
    #위쪽 순환
    for i in range(1, C):
        up_path.append((upper, i))
    for i in range(upper-1, -1, -1):
        up_path.append((i, C - 1))
    for i in range(C-2, -1, -1):
        up_path.append((0, i))
    for i in range(1, upper):
        up_path.append((i, 0))

    down_path = []
    # 아래쪽 순환
    for y in range(1, C):
        down_path.append((lower, y))
        # 3-2) 오른쪽 끝에서 아래쪽 끝까지
    for x in range(lower + 1, R):
        down_path.append((x, C - 1))
        # 3-3) 하단 행에서 왼쪽 끝까지
    for y in range(C - 2, -1, -1):
        down_path.append((R - 1, y))
        # 3-4) 왼쪽 끝에서 공기청정기 바로 아래까지
    for x in range(R - 2, lower, -1):
        down_path.append((x, 0))

    prev = 0
    for x, y in up_path:
        graph[x][y], prev = prev, graph[x][y]

    prev = 0
    for x, y in down_path:
        graph[x][y], prev = prev, graph[x][y]


# print(graph)
# print("tmp")
#
# print("====")
# print(graph)

for i in range(T):
    spread()
    clean_machine()
# print(graph)
ans = 0
for i in range(R):
    for j in range(C):
        if graph[i][j] > 0:
            ans += graph[i][j]

print(ans)


















