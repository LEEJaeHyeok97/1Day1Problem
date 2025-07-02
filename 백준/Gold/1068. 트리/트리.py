from collections import deque

# 트리 저장
# 노드 삭제
# BFS 리프 탐색

N = int(input())
# graph = {0: [1, 2], 1: [0], 2: [0, 3, 4], 3: [2], 4: [2, 5, 6], 5 : [4], 6 : [4, 7, 8], 7 : [6], 8 : [6]}
# graph = {0: [1, 2], 1: [0, 3, 4], 2: [0], 3: [1], 4: [1]}
graph = {i : [] for i in range(N)}


root = 0
tmp = list(map(int, input().split()))
for i in range(N):
    if tmp[i] == -1:
        root = i
        continue
    graph[i].append(tmp[i])
    graph[tmp[i]].append(i)

# print(graph)

del_node = int(input())

if root == del_node:
    print(0)
    exit()


visited = []
q = deque([root])
graph[del_node] = []
for key, v in graph.items():
    if del_node in v:
        graph[key].remove(del_node)

# print(graph)


ans = 0
def bfs(root):
    global ans
    while q:
        cur = q.popleft()
        visited.append(cur)

        is_leaf = True

        for i in graph[cur]:
            if i not in visited:
                q.append(i)
                is_leaf = False

        if is_leaf:
            ans += 1

bfs(root)
print(ans)