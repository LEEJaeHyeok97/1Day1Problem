N, M = map(int, input().split())

li = [list(input()) for _ in range(N)]


# print(li)
# print(li[0])

ans = 1
max_length = min(N, M)
if N == 1 or M == 1:
    print(ans)
else:
    for k in range(1, max_length):
        # print("k: ", k)
        for i in range(N):
            for j in range(M):
                tmp = li[i][j]
                if i + k < N and j + k < M:
                    if tmp == li[i + k][j + k] and tmp == li[i + k][j] and tmp == li[i][j + k]:
                        ans = k + 1
                else:
                    continue

    print(ans*ans)