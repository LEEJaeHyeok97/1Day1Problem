li = []

K = int(input())

for i in range(K):
    tmp = int(input())
    if tmp == 0:
        li.pop()
        continue
    li.append(tmp)

print(sum(li))


