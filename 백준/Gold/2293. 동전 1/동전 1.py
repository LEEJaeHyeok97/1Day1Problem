n, k = map(int, input().split())

coins = [int(input()) for _ in range(n)]

# 동전은 같은 걸 몇 개를 사용해도 상관 없음!
# 3 4 7 10
# 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
# 0 0 0 1 1 0 1 2 1 1 3
# 3,3,4 3,7 10

dp = [0] * (k + 1)
dp[0] = 1

for coin in coins:
    for i in range(coin, k + 1):
        dp[i] += dp[i - coin]
print(dp[-1])




