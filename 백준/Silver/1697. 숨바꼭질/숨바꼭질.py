

N, K = map(int, input().split())


visited = [False for _ in range(100001)]


queue = []
queue.insert(0, N)
visited[N] = True

count = 0

while queue:
    now_list = []
    while queue:
        now_list.append(queue.pop())
    if K in now_list:
        break
    count += 1
    for now in now_list:
        if 0 <= now + 1 <= 100000 and not visited[now+1]:
            queue.insert(0, now+1)
            visited[now+1] = True
        if 0 <= now - 1 <= 100000 and not visited[now-1]:
            queue.insert(0, now-1)
            visited[now-1] = True
        if 0 <= now * 2 <= 100000 and not visited[2*now]:
            queue.insert(0, now*2)
            visited[now*2] = True


print(count)