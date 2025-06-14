from itertools import combinations
N = int(input())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

# print(graph)

li = list(combinations(range(1, N + 1), N//2))


ans_li = []
for start in li:
    link = [x for x in list(range(1, N + 1)) if x not in start]
    start_score = 0
    link_score = 0
    # print(start)
    # print(link)

    for a, b in list(combinations(start, 2)):
        start_score += graph[a - 1][b - 1]
        start_score += graph[b - 1][a - 1]
    for a, b in list(combinations(link, 2)):
        link_score += graph[a - 1][b - 1]
        link_score += graph[b - 1][a - 1]

    ans_li.append(abs(start_score - link_score))


print(min(ans_li))
