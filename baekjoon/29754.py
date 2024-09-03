from datetime import datetime

N, M = map(int, input().split())
M = M // 7

li = [dict() for _ in range(M)]


for i in range(N):
    tmp = input().split()
    week = (int(tmp[1]) - 1) // 7

    time1 = datetime.strptime(tmp[3], "%H:%M")
    time2 = datetime.strptime(tmp[2], "%H:%M")

    time_diff = time1 - time2

    if tmp[0] not in li[week]:
        li[week][tmp[0]] = [time_diff, 1]
    else:
        li[week][tmp[0]][0] += time_diff
        li[week][tmp[0]][1] += 1

candidates = set(li[0].keys())

for week_data in li:
    current_week_valid = set()
    for name, data in week_data.items():
        total_seconds = data[0].total_seconds()
        hours = total_seconds / 3600
        if hours >= 60 and data[1] >= 5:
            current_week_valid.add(name)

    candidates &= current_week_valid


if len(candidates) == 0:
    print("-1")
else:
    ans = list(candidates)
    ans.sort()
    for i in ans:
        print(i)