while True:
    try:
        s, t = map(str, input().split())
        flag = 0
        cnt = 0
        for i in t:
            if i == s[flag]:
                cnt += 1
                flag += 1
            if len(s) == flag:
                break

        if cnt == len(s):
            print("Yes")
        else:
            print("No")

    except:
        break