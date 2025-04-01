from itertools import combinations

L, C = map(int, input().split())

# print(L, C)

li = input().split()

aeiou = ["a", "e", "i", "o", "u"]

li1 = []
li2 = []

for i in li:
    if i in aeiou:
        li1.append(i)
    else:
        li2.append(i)

ans = []

c = list(combinations(li, L))

for i in c:
    ans.append(''.join(sorted(list(''.join(i)))))

# print(ans)

final_ans = []
for i in ans:
    a = 0
    b = 0
    for j in i:
        if j in aeiou:
            a += 1
        else:
            b += 1
    if a >= 1 and b >= 2:
        final_ans.append(i)
final_ans = sorted(final_ans)
for i in final_ans:
    print(i)