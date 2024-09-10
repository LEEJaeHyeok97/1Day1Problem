n = int(input())

p1, p2 = map(int, input().split())

m = int(input())

graph = {}

for _ in range(m):
    x, y = map(int, input().split())

    if x not in graph:
        graph[x] = [y]
    else:
        graph[x].append(y)
    if y not in graph:
        graph[y] = [x]
    else:
        graph[y].append(x)

cnt = -1
flag = 0

def dfs(graph, cur_v, target, visited = set()):
    global cnt, flag
    visited.add(cur_v)
    cnt += 1

    if cur_v == target:
        flag = 1
        return

    for v in graph[cur_v]:
        if v not in visited:
            dfs(graph, v, target, visited)
            if flag == 1:
                return
    cnt -= 1

dfs(graph, p1, p2)

if flag == 1:
    print(cnt)
else:
    print(-1)