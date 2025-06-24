N = int(input())

if N == 1:
    print(0)
    exit()
if N == 2:
    print(1)
    exit()
if N == 3:
    print(1)
    exit()

dp = [0] * (N + 1)
for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[N])