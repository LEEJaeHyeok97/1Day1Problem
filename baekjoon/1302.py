n = int(input())

dict = {}

for i in range(n):
    bookName = input()
    if bookName not in dict:
        dict[bookName] = 1
    else:
        dict[bookName] += 1

ans = sorted(dict.items(), key=lambda x: (-x[1], x[0]))

print(ans[0][0])