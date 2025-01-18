import sys
input = sys.stdin.readline

m = 0

m_idx = 0

pil = [0 for i in range(1001)]

for _ in range(int(input())):
    L, H = map(int, input().split())
    pil[L] = H
    if m < H:
        m_idx = L
        m = H
cur = 0
answer = 0

for i in range(m_idx+1):
    cur = max(cur, pil[i])
    answer += cur
cur = 0
for i in range(1000, m_idx, -1):
    cur = max(cur, pil[i])
    answer += cur
print(answer)