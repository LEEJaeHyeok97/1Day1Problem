N = int(input())
M = int(input())
votes = list(map(int, input().split()))

frames = {}
time = 0

for student in votes:
    if student in frames:
        frames[student][0] += 1
    else:
        if len(frames) < N:
            frames[student] = [1, time]
        else:
            student_to_remove = min(frames.items(), key=lambda x: (x[1][0], x[1][1]))[0]
            del frames[student_to_remove]
            frames[student] = [1, time]
    time += 1

print(' '.join(map(str, sorted(frames.keys()))))
