N = int(input())
M = int(input())

s = input()

ans = 0
i = 0
cnt = 0

while i < M - 1:
    if s[i:i+3] == 'IOI':
        i += 2
        cnt += 1
        if cnt == N:
            ans += 1
            cnt -= 1
    else:
        i += 1
        cnt = 0

print(ans)