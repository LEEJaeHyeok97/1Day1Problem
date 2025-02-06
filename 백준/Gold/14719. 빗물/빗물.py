H, W = map(int, input().split())

li = list(map(int, input().split()))


left_li = []
right_li = []


tmp = li[0]
for i in range(1, W - 1):
    if li[i] > tmp:
        tmp = li[i]
    left_li.append(tmp - li[i])

tmp = li[-1]
for i in range(W - 2, 0, -1):
    if li[i] > tmp:
        tmp = li[i]
    right_li.append(tmp - li[i])
right_li.reverse()

cnt = 0
for i in range(len(left_li)):
    tmp = min(left_li[i], right_li[i])
    cnt += tmp

print(cnt)