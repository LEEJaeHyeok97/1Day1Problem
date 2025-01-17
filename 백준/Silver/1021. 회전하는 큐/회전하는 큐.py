import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

out_list = list(map(int, sys.stdin.readline().split()))

q = deque()

for i in range(n):
    q.append(i + 1)

count = 0
flag = 0

while flag < m:
    if out_list[flag] == q[0]:
        q.popleft()
        flag += 1
    else:
        mid = int(len(q) / 2)
        if q.index(out_list[flag]) <= mid:
            temp = q.popleft()
            q.append(temp)
            count += 1
        else:
            temp = q.pop()
            q.appendleft(temp)
            count += 1
print(count)