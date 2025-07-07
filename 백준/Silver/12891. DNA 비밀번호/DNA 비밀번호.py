s, p = map(int, input().split())
str = input()


a, c, g, t = map(int, input().split())

result = 0

start = str[:p]

tmp = {"A" : 0, "C" : 0, "G" : 0, "T" : 0}
for i in start:
    tmp[i] += 1

cnt = 0
if tmp["A"] >= a and tmp["C"] >= c and tmp["G"] >= g and tmp["T"] >= t:
    cnt +=1


start_idx = 0
end_idx = start_idx + p

for i in range(len(str) - p):
    tmp[str[start_idx+i]] -= 1
    tmp[str[end_idx+i]] += 1
    if tmp["A"] >= a and tmp["C"] >= c and tmp["G"] >= g and tmp["T"] >= t:
        cnt += 1


print(cnt)




