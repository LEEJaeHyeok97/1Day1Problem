from collections import deque

N, M = map(int, input().split())


q = deque([])

def backtracking(start):
    if len(q) == M:
        print(' '.join(map(str, q)))
        return

    for i in range(1, N + 1):
        q.append(i)
        backtracking(i)
        q.pop()

backtracking(1)