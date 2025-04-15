N = int(input())
order_cnt = int((input()))

order = list(map(int, input().split()))

frames = {}

time = 0
for i in order:
    if i in frames:
        frames[i][0] += 1
    else:
        if len(frames) < N:
            frames[i] = [1, time]
        else:
            student_to_remove = min(frames.items(), key=lambda x: (x[1][0], x[1][1]))[0]
            del frames[student_to_remove]
            frames[i] = [1, time]
    time += 1

print(' '.join(map(str, sorted(frames.keys()))))
