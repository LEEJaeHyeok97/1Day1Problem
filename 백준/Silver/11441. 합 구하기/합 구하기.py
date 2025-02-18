N = int(input())
li1 = list(map(int, input().split()))

M = int(input())
li2 = [list(map(int, input().split())) for _ in range(M)]


for a, b in li2:
    print(sum(li1[a-1:b]))