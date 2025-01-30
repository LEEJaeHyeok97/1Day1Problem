from collections import deque


def backtracking(depth, idx):
    if depth == 6:
        print(' '.join(map(str, q)))
        return

    for i in range(idx, k):
        q.append(s[i])
        backtracking(depth+1, i + 1)
        q.pop()

while True:
    tmp = list(map(int, input().split()))
    k = tmp[0]
    s = tmp[1:]
    q = deque([])
    backtracking(0, 0)
    if k == 0:
        break
    print()