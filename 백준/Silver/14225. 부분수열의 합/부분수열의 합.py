import itertools

N = int(input())

li = list(map(int, input().split()))


li.sort()


new_li = []


for i in range(1, N + 1):
    l = list(itertools.combinations(li, i))
    for j in l:
        new_li.append(sum(j))
new_li = list(set(new_li))
new_li.sort()

flag = new_li[0]
count = 0

x = 1

for i in range(len(new_li)):
    if new_li[i] == x:
        x += 1
    else:
        break
print(x)