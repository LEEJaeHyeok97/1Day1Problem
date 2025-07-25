# 거인의 나라 인구 수 N
# 센티의 키 H
# 뿅망치 횟수 T

import heapq
import math

N, H, T = map(int, input().split())

# print(N, H, T)

li = []
for _ in range(N):
    li.append(int(input()) * -1)
# print(li)
heapq.heapify(li)
# print(heapq.heappop(li))
# print(heapq.heappop(li))

cnt = 0
for _ in range(T):
    tallest = -heapq.heappop(li)

    if tallest < H:
        heapq.heappush(li, -tallest)
        break

    if tallest == 1:
        heapq.heappush(li, -1)
        break

    heapq.heappush(li, -(tallest//2))
    cnt += 1

if -li[0] < H:
    print("YES")
    print(cnt)
else:
    print("NO")
    print(-li[0])



