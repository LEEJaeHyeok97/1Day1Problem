import sys

input = sys.stdin.readline

N, M = map(int, input().split())

li = []

for i in range(N):
    word = input().strip()
    if len(word) >= M:
        li.append(word)

dict = {}

for i in li:
    if i not in dict:
        dict[i] = 1
    else:
        dict[i] += 1

sorted_dict1 = sorted(dict.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for i in sorted_dict1:
    print(i[0])