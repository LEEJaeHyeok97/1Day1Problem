# 0,2 / 4, 4
# 1,1 / 2, 5
# 4,0 / 6, 2


M, N, K = map(int, input().split())

graph = [[0] * N for i in range(M)]

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

# print(graph)

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())

    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

# print(graph)
st = []
li = []
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            st.append((i, j))

            cnt = 0
            while st:
                x, y = st.pop()

                for i in range(4):
                    nx = dx[i] + x
                    ny = dy[i] + y

                    if not (0 <= nx < M and 0 <= ny < N):
                        continue
                    # print((nx, ny))
                    if graph[nx][ny] == 1:
                        continue

                    graph[nx][ny] = 1
                    st.append((nx, ny))
                    cnt += 1
            if cnt == 0:
                li.append(1)
            else:
                li.append(cnt)

print(len(li))
print(*sorted(li))
# print(st)












