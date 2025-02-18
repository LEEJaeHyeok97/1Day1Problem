N = int(input())
counts = list(map(int, input().split()))
result = []

for i in range(N - 1, -1, -1):
    result.insert(counts[i], i + 1)

print(" ".join(map(str, result)))