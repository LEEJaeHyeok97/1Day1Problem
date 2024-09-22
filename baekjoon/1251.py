s = input()

li = []
li2 = []

for i in range(1, len(s) - 1):
    for j in range(i + 1, len(s)):
        tmp = []
        tmp.append(s[:i])
        tmp.append(s[i:j])
        tmp.append(s[j:])
        li.append(tmp)

# print(li)

for i in li:
    tmp_s = ''
    for j in i:
        tmp_s += j[::-1]
    li2.append(tmp_s)
# print(li2)

li2.sort()
print(li2[0])
