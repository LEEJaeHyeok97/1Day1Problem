N = int(input())
M = int(input())


li = list(map(int, input().split()))
li.sort()

left = 0
right = len(li) - 1

cnt = 0
while left < right:
    if li[left] + li[right] == M:
        cnt += 1
        left += 1
        right -= 1
    elif li[left] + li[right] > M:
        right -= 1
    elif li[left] + li[right] < M:
        left += 1

print(cnt)