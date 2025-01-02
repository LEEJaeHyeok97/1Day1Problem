import sys
input = sys.stdin.readline


dic = {}

while True:
    s = input().strip()

    if not s:
        break

    if s in dic:
        dic[s] += 1

    if s not in dic:
        dic[s] = 1


total_count = sum(dic.values())

new_dict = dict(sorted(dic.items()))

for k, v in new_dict.items():
    new_v = v / total_count * 100
    print("%s %.4f" %(k, new_v))
