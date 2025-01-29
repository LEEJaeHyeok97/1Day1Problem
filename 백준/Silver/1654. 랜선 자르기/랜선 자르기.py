K, N = map(int, input().split())

li = []

for i in range(K):
    li.append(int(input()))

li.sort()
start = 1
end = max(li)

while True:
    if start > end:
        break

    mid = (start + end) // 2
    cut_count = 0
    for i in li:
        tmp = i // mid
        cut_count += tmp

    if cut_count >= N:
        start = mid + 1
    else:
        end = mid - 1

print(end)