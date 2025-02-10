N = int(input())

if N == 1:
    print(3)
elif N == 2:
    print(7)
else:
    a, b = 3, 7  # a: dp[i-2], b: dp[i-1]
    for i in range(3, N+1):
        a, b = b, (2 * b + a) % 9901
    print(b)