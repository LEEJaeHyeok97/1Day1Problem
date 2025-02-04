
n = int(input())

li = list(map(int, input().split()))

x = int(input())

li.sort()


start = 0
end = len(li) - 1
cnt = 0
while start < end:
    tmp = li[start] + li[end]
    if tmp == x:
        cnt += 1
        end -= 1
    if tmp < x:
        start += 1
    if tmp > x:
        end -= 1

print(cnt)