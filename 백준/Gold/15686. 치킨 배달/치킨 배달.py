# 도시의치킨거리= 모든 비의 치킨거리의 합

# 두 칸의 거리 =|r1-r2| + |c1-c2|


# 0:빈칸,1:집, 2:치킨집

# 어느집의 치킨 거리는 최단 치킨거리로결정됨

# 치킨 집중 M개를 고르고 도시의 치킨 거리가 가장 작게될 수 있게 하는 프로그램을 작성


# 모듈
# 1. 현재 그래프의 도시치킨거리 구하기
# 2. 치킨 집 좌표 수집 후, M개 뽑고
# 3. 각각 1번 모듈 돌리기
from collections import deque
from itertools import combinations
from copy import deepcopy

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]


# print(graph)
def bfs(x, y):
    q = deque([])
    q.append((x, y))
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True

    dist = 0
    while q:
        x1, y1 = q.popleft()
        for i in range(4):
            nx = x1 + dx[i]
            ny = y1 + dy[i]

            if not (0 <= nx < N and 0 <= ny < N) or visited[nx][ny] == True:
                continue
            dist = abs(x - nx) + abs(y - ny)
            if graph[nx][ny] == 2:
                return dist
            visited[nx][ny] = True
            q.append((nx, ny))


def chicken_dist(graph):
    li = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1:
                dist = bfs(i, j)
                li.append(dist)
    return li

chicken_li = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 2:
            chicken_li.append((i, j))

selected_chicken_li = list(combinations(chicken_li, M))
# print(selected_chicken_li)
houses = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            houses.append((i, j))

ans = []
for selected in selected_chicken_li:
    total = 0
    for hx, hy in houses:
        first_cx, first_cy = selected[0]
        min_dist = abs(hx - first_cx) + abs(hy - first_cy)

        for cx, cy in selected[1:]:
            dist = abs(hx - cx) + abs(hy - cy)
            if dist < min_dist:
                min_dist = dist

        total += min_dist

    ans.append(total)

print(min(ans))


# chicken_dist(graph)
# print(li)
# print(sum(li))
