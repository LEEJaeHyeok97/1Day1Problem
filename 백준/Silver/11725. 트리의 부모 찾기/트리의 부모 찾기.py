import sys
sys.setrecursionlimit(10**6)

N = int(input())
edges = [list(map(int, input().split())) for _ in range(N - 1)]

tree = {i: [] for i in range(1, N + 1)}

for edge in edges:
    s, e = edge
    tree[s].append(e)
    tree[e].append(s)

parents = [0] * (N + 1)
def traverse(cur, parent):

    for next in tree[cur]:
        if next == parent:
            continue
        parents[next] = cur
        traverse(next, cur)

traverse(1, 0)

print(*parents[2:], sep="\n")