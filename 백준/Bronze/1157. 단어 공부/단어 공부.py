from collections import defaultdict

s = input()

s = s.lower()

# print(s)

dic = defaultdict(int)

for i in s:
    if i not in dic:
        dic[i] = 1
    else:
        dic[i] += 1

# print(list(dic.items()))

li = list(dic.items())

li.sort(key=lambda x: x[1], reverse=True)

if len(li) >= 2:
    if li[0][1] == li[1][1]:
        print("?")
    else:
        print(li[0][0].upper())
else:
    print(li[0][0].upper())

# print(li)
# for i, v in dic.items():
