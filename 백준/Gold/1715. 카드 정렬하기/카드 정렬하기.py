import heapq

# A B
N = int(input())

li = []

for _ in range(N):
    heapq.heappush(li, int(input()))

# print(li)
heapq.heapify(li)

ans = 0
# print(li)
while len(li) > 1:
    # print(li)
    a = heapq.heappop(li)
    b = heapq.heappop(li)

    ans += (a + b)
    # print(ans)
    heapq.heappush(li, a+b)


print(ans)

