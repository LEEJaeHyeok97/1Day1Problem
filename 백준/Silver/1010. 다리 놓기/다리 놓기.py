from itertools import combinations

MAX = 31

dp = [[0] * MAX for _ in range(MAX)]

# 기본 조합 값 초기화
for n in range(MAX):
    for r in range(n + 1):
        if r == 0 or r == n:
            dp[n][r] = 1
        else:
            dp[n][r] = dp[n-1][r-1] + dp[n-1][r]

T = int(input())
idx = 1
for _ in range(T):
    N, M = map(int, input().split())
    print(dp[M][N])