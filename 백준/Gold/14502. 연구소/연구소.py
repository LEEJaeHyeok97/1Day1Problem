#
import itertools
from itertools import combinations
from collections import deque
from copy import deepcopy

N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))


dx = [-1,0, 0, 1]
dy = [0, -1, 1, 0]


def bfs(x, y, temp_graph):
    queue = deque([(x, y)])

    while queue:
        xx, yy = queue.popleft()

        for i in range(4):
            nx = xx + dx[i]
            ny = yy + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if temp_graph[nx][ny] == 0:
                    temp_graph[nx][ny] = -2
                    queue.append((nx, ny))
    return temp_graph



def main(stick_li):
    li = []
    temp_graph = deepcopy(graph)
    for a, b in stick_li:
        temp_graph[a][b] = 1

    q = deque()
    for i in range(N):
        for j in range(M):
            if temp_graph[i][j] == 2:
                q.append((i, j))

    while q:
        xx, yy = q.popleft()

        for i in range(4):
            nx = xx + dx[i]
            ny = yy + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if temp_graph[nx][ny] == 0:
                    temp_graph[nx][ny] = 2
                    q.append((nx, ny))

    ans = 0
    for row in temp_graph:
        ans += row.count(0)
    return ans

empty_positions = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            empty_positions.append((i, j))

combi_list = list(combinations(empty_positions, 3))

ans_li = []
for walls in combi_list:
    res = main(walls)
    ans_li.append(res)

print(max(ans_li))