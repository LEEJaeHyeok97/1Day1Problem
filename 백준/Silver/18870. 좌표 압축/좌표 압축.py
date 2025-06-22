N = int(input())

li = list(map(int, input().split()))


# print(li)

sorted_set = sorted(set(li))
# print(sorted_set)
dic = {}
for idx, value in enumerate(sorted_set):
    dic[value] = idx

# print(dic)
for i in li:
    print(dic[i], end=" ")