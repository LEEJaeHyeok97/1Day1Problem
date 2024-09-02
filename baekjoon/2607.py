n = int(input())

word = input()
standard_dict = {}

for i in word:
    if i not in standard_dict:
        standard_dict[i] = 1
    else:
        standard_dict[i] += 1

ans = 0

for i in range(n-1):
    word2 = input()
    tmp_dict={}

    for j in word2:
        if j not in tmp_dict:
            tmp_dict[j]=1
        else:
            tmp_dict[j] += 1

    len_diff = abs(len(word) - len(word2))



    diff = 0
    for k in standard_dict:
        diff += abs(standard_dict.get(k, 0) - tmp_dict.get(k, 0))

    for k in tmp_dict:
        if k not in standard_dict:
            diff += tmp_dict[k]

    # 이 부분이 바뀌는 문자열 차이를 고려하는 부분(중요)
    if diff <= 2 and len_diff < 2:
        ans += 1


print(ans)