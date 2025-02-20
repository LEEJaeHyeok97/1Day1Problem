import sys

n, m = map(int, sys.stdin.readline().split())

li = [i for i in range(n + 1)]

def union(a, b):
    if (find(a) != find(b)):
        li[find(b)] = find(a)

def find(a):
    if (li[a] == a):
        return a
    else:
        li[a] = find(li[a])
        return li[a]
    
def check(a, b):
    return (find(a) == find(b))

for _ in range(m):
    op, a, b = map(int, sys.stdin.readline().split())

    if (op == 0):
        union(a, b)
    else:
        if (check(a, b)):
            print('YES')
        else:
            print('NO')