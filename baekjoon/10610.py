n = input()

if '0' not in n:
    print(-1)
else:
    s = 0
    for i in n:
        s += int(i)
    if s % 3 != 0:
        print(-1)
    else:
        li = []
        for i in n:
            li.append(i)
        li.sort(reverse=True)
        ans = ''.join(li)
        print(ans)
