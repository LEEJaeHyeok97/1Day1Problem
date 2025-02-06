N = int(input())

li = list(map(int, input().split()))

li.sort()
i = len(li)
print(li[(N - 1) // 2])