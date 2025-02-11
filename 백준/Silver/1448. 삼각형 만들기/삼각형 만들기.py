N = int(input())

li = [int(input()) for _ in range(N)]

li.sort()
sorted_li = li[::-1]

flag = 0
for i in range(N - 2):
    a, b, c = sorted_li[i:i+3]
    # print(tmp)
    # print(a, b, c)
    if (a + b) <= c or (a + c) <= b or (b + c) <= a:
        continue
    else:
        print(a+b+c)
        flag = 1
        break
if flag == 0:
    print(-1)