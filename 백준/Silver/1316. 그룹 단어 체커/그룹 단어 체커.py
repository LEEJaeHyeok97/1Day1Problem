# 단어 입력 / 목록 리스트 출력
# 목록 리스트 입력 / 중복 검사 리스트에 이미 있는 요소인지 확인 후 각 요소를 다른 문자가 나오기전까지 중복 검사 리스트에 저장
# 중복 검사 리스트가 온전히 만들어진걸 카운팅 +1 입력 / 카운팅 출력

import sys
input = sys.stdin.readline


t = int(input())

cnt =  0

words = []
for _ in range(t):
    words.append(input())

for word in words:
    used_li = []
    cur_word = ''
    flag = 1
    for c in word:
        if cur_word != c and c not in used_li:
            cur_word = c
            used_li.append(c)
            continue
        if cur_word == c:
            continue
        if cur_word != c and c in used_li:
            flag = 0
            break

    if flag == 1:
        cnt += 1

print(cnt)
