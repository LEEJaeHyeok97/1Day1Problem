N = int(input())

li = [list(map(int, input().split())) for _ in range(N)]


sorted_li = sorted(li, key=lambda x: (x[1], x[0]))

if N == 1:
    print(1)
else:
    ans = []
    endPoint = sorted_li[0][1]
    cnt = 1
    for a, b in sorted_li[1:]:
        if endPoint > a:
            continue
        else:
            endPoint = b
            cnt += 1

    print(cnt)