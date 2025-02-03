T = int(input())

for _ in range(T):
    s = input()

    li = []
    start = 0
    end = len(s) - 1
    cnt = 0
    while start < end:
        if s[start] != s[end]:
            cnt += 1
            start += 1
            continue
        start += 1
        end -= 1
    li.append(cnt)

    start = 0
    end = len(s) - 1
    cnt = 0
    while start < end:
        if s[start] != s[end]:
            cnt += 1
            end -= 1
            continue
        start += 1
        end -= 1

    li.append(cnt)

    if min(li) == 0:
        print(0)
    elif min(li) == 1:
        print(1)
    else:
        print(2)
