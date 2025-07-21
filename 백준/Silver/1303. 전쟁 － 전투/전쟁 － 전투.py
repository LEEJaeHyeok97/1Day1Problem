# 같은 팀의 병사는 모일수록 강해진다.
# N명이 뭉친다-> N^2위력
# 대각선은 뭉침x

# W:9^2 + 7^2 B: 1 + 8^2

N, M = map(int, input().split())
# print(N, M)

graph = [list(input()) for _ in range(M)]
# print(graph)
# graph = [
# ['W', 'B', 'W', 'W', 'W'],
# ['W', 'W', 'W', 'W', 'W'],
# ['B', 'B', 'B', 'B', 'B'],
# ['B', 'B', 'B', 'W', 'W'],
# ['W', 'W', 'W', 'W', 'W']
# ]

st = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

W = []
B = []

# print("check1")
def dfs(x, y, color):
    cnt = 0
    st.append((x, y))
    # print("check2")
    while st:
        x, y = st.pop()
        # print(x, y, "check3")
        if graph[x][y] == 'S':
            continue
        if not (0 <= x < M and 0 <= y < N):
            continue

        graph[x][y] = 'S'
        cnt += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]


            if not (0 <= nx < M and 0 <= ny < N):
                continue
            if graph[nx][ny] == 'S':
                continue
            if not (graph[nx][ny] == color):
                continue

            st.append((nx, ny))

    # print(cnt)
    if color == 'W':
        W.append(cnt)
    else:
        B.append(cnt)



for i in range(M):
    for j in range(N):
        if not (graph[i][j] == 'S'):
            dfs(i, j, graph[i][j])

# print(W)
# print(B)

tmp = 0
for i in W:
    tmp += i**2
print(tmp, end=" ")

tmp = 0
for i in B:
    tmp += i**2
print(tmp)


