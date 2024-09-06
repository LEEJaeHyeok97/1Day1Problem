N = int(input())


li1 = input().split()

dict = {}
ans = []

for i in li1:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1


M = int(input())
li2 = input().split()

for i in li2:
    if i not in dict:
        ans.append(0)
    else:
        ans.append(dict[i])

for i in ans:
    print(i, end=' ')