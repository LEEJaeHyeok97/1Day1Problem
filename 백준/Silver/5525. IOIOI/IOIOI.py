N = int(input())

M = int(input())

S = input()

cnt = 0
from_n = "I" + "OI" * N
# print(from_n)
len_from_n = len(from_n)

for i in range(0, M - len_from_n + 1):
    # print(S[i:i + len_from_n])
    if from_n == S[i:i + len_from_n]:
        cnt += 1

print(cnt)