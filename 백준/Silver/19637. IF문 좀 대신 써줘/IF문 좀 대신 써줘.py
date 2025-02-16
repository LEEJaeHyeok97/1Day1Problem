import sys

N, M = map(int, sys.stdin.readline().split(' '))

new_li = []

for i in range(N):
    a, b = sys.stdin.readline().split(' ')
    new_li.append([a, int(b)])

new_li.sort(key = lambda x: x[1])

for i in range(M):
    tmp = int(sys.stdin.readline().rstrip())
    start = 0
    end = len(new_li) - 1
    while start <= end:
        mid = (start + end) // 2
        if tmp > (new_li[mid][1]):
            start = mid + 1
        else:
            end = mid - 1
    print(new_li[start][0])