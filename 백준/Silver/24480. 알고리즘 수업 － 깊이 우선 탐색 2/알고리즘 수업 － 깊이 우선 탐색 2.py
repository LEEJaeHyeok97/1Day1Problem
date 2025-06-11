import sys
sys.setrecursionlimit(10**5)
N, M, R = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort(reverse=True)

li = [0] * N
cnt = 0
visited = [0] * N

# 재귀함수
def dfs(R):
    # 재귀 종료 조건
    global cnt
    if cnt == len(graph) + 1:
        return
    # print(cnt)
    cnt += 1
    visited[R - 1] = cnt
    # print(visited)
    for i in graph[R]:
        if visited[i - 1] == 0:
            dfs(i)


dfs(R)

# li 순서대로 출력
for n in visited:
    print(n)
