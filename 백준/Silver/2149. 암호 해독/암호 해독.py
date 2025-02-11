key = input()

encrypt_s = input()

sorted_key = sorted(list(key))
# print(''.join(sorted_key))

l = len(encrypt_s) // len(key)

li = []
flag = 0
for i in sorted_key:
    li.append([i, encrypt_s[flag:flag + l]])
    flag += l

# print(li)

ans_li = []
for i in key:
    for j, (a, b) in enumerate(li):
        if i == a:
            ans_li.append(b)
            li.pop(j)
            break

for k in range(len(ans_li[0])):
    for j in ans_li:
        print(j[k], end ='')



