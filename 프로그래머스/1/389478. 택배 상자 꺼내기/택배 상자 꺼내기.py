def solution(n, w, num):
    li = [[-1] * w for _ in range(n // w + 1)]
    
    li = []
    
    tmp = []
    flag = 0
    for i in range(1, n + 1):
        tmp.append(i)
        if len(tmp) == w:
            if flag % 2 == 1:
                tmp = tmp[::-1]
            li.append(tmp)
            tmp = []
            flag += 1
            
    
    if len(tmp) != w:
        while len(tmp) < w:
            tmp.append(-1)
        if flag % 2 == 1:
            tmp = tmp[::-1]
        li.append(tmp)
    li.append([-2] * w)
        
    answer = 0
    x = 0
    y = 0
    flag2 = False
    for i in range((n // w + 1)):
        for j in range(w):
            if li[i][j] == num:
                x = i
                y = j
                flag2 = True
                break
        if flag2:
            break
    
    cnt = 1
    for i in range(x + 1, ((n // w) + 3)):
        print(li[i][y])
        if li[i][y] == -2:
            print(cnt)
            break
        if li[i][y] != -1:
            print(cnt)
            cnt += 1
        
        
    print(li)
    print(cnt)
    
    return cnt