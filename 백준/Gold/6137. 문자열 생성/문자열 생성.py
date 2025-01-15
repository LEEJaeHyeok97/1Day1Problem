import sys

N = int(sys.stdin.readline().rstrip())


S = ""

for i in range(N):
    tmp = sys.stdin.readline().rstrip()
    S += tmp


T = ""

first = 0
end = len(S) - 1

T = []

while first <= end:
    if S[first] > S[end]:
        T.append(S[end])
        end -= 1
    elif S[first] < S[end]:
        T.append(S[first])
        first += 1
    else:
        new_first = first + 1
        new_end = end - 1
        flag = 0
            
        while new_first <= new_end:
            if S[new_first] < S[new_end]:
                flag = 1
                break
            elif S[new_first] > S[new_end]:
                flag = 2
                break
            new_first += 1
            new_end -= 1
        if flag == 1:
            T.append(S[first])
            first += 1
        elif flag == 2:
            T.append(S[end])
            end -= 1
        else:
            T.append(S[first])
            first += 1
count = 0

for i in T:
    print(i, end = '')
    count += 1
    if count % 80 == 0:
        print()