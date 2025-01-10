from itertools import permutations

N, M = map(int, input().split())

li = []

for i in range(1, N + 1):
    li.append(i)

if M == 1:
    for i in range(1, N + 1):
        print(i)

else:
    p_li = list(permutations(li, M))
    p_li.sort()

    for i in p_li:
        for _ in i:
            print(_, end=" ")
        print()
