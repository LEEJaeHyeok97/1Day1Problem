N = int(input())
M = int(input())

parent = [i for i in range(N+1)]

def get_parent(x):
    if parent[x] == x:
        return x
    parent[x] = get_parent(parent[x])
    return parent[x]

def union_parent(a, b):
    a = get_parent(a)
    b = get_parent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def same_parent(a, b):
    return get_parent(a) == get_parent(b)


li = [list(map(int, input().split())) for i in range(M)]
li.sort(key=lambda x: x[2])

# print(li)

ans = []
for a, b, c in li:
    if same_parent(a, b):
        continue
    union_parent(a, b)
    ans.append(c)
print(sum(ans))