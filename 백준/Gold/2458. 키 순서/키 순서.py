import sys
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())

taller = [[] for _ in range(N)]
shorter = [[] for _ in range(N)]

for _ in range(M):
    a, b= map(int, input().split())
    a -= 1
    b -= 1

    taller[a].append(b)
    shorter[b].append(a)


def dfs(graph, start, visited):
    for next in graph[start]:
        if not visited[next]:
            visited[next] = True
            dfs(graph, next, visited)


ans = 0
for i in range(N):
    visited_taller = [False] * N
    visited_shorter = [False] * N

    visited_taller[i] = True
    visited_shorter[i] = True

    dfs(taller, i, visited_taller)
    dfs(shorter, i, visited_shorter)

    total_known = sum(visited_taller) + sum(visited_shorter) - 2
    if total_known == N - 1:
        ans += 1

print(ans)