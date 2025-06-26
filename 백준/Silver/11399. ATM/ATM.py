N = int(input())

line = list(map(int, input().split()))

li = []

ans = 0
t = 0
while line:
    min_value = min(line)
    t += min_value
    ans += t
    line.remove(min_value)

print(ans)