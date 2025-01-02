
dict = {}

S = input()

s_len = int(len(S))

for i in range(1, s_len + 1):
    for j in range(s_len):
        dict[S[j:j+i]] = 1

print(len(dict.items()))