from collections import deque

T = int(input())


for _ in range(T):
    N, M = map(int, input().split())
    properties = list(map(int, input().split()))
    dq = deque((priority, idx) for idx, priority in enumerate(properties))

    count = 0

    while True:
        current = dq.popleft()

        if any(current[0] < other[0] for other in dq):
            dq.append(current)
        else:
            count += 1
            if current[1] == M:
                print(count)
                break

