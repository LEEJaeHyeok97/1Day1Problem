import collections


N , M = map(int, input().split())

graph = collections.defaultdict(list)

def bfs(cur_v, graph, visited):
    queue = collections.deque([cur_v])
    tmp = []
    while queue:
        popleft = queue.popleft()
        if popleft not in visited:
            visited.add(popleft)
            tmp.append(popleft)
            queue.extend(graph[popleft])

    return len(tmp)


for _ in range(M):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

visited = set([])
# ans = bfs(1, graph)
# print(ans)

ans = []
for i in range(1, N + 1):
    if i not in visited:
        tmp = bfs(i, graph, visited)
        ans.append(tmp)
# print(ans)

final_ans = 1
for i in ans:
    final_ans *= i
print(final_ans % 1000000007)