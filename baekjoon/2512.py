N = int(input())

li = list(map(int, input().split()))

M = int(input())


start = 0
end = max(li)

while start <= end:
    mid = (start + end) // 2
    cur = 0

    for i in li:
        if i >= mid:
            cur += mid
        else:
            cur += i

    if cur <= M:
        start = mid + 1
    else:
        end = mid - 1

print(end)