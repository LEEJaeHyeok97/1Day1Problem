from collections import deque

n = int(input())

A = list(map(int, input().split()))

# print(A)

start = int(input())
q = deque([start - 1])

visited = [0] * n
cnt = 1
while q:
    cur_v = q.popleft()

    for i in [cur_v + A[cur_v], cur_v - A[cur_v]]:
        if (0 <= i < n) and visited[i] == 0:
            q.append(i)
            visited[i] = 1
            cnt += 1

# print("=====")
print(cnt)