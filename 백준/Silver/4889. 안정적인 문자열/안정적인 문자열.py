### ⭐️ 문제에서 주로 사용한 알고리즘
# 스택, 문자열

### 대략적인 코드 설명
# 문자열 배열 입력 / 스택으로 자료형 변환
# 스택 문자열 앞에서 하나씩 빼서 검사 / '{' 면 스택에 추가, '}'면 스택이 비어있으면 cnt++ 후 '{' 스택에 추가,
# '}'인데 스택이 비어있지 않으면 스택에서 하나 pop
# 최종적으로 만들어진 스택 배열 확인 / 스택 비어있으면 cnt 출력, 스택이 차있으면 항상 짝수이므로 스택 size // 2 + cnt
from collections import deque

flag = 0
while True:
    flag += 1
    s = list(input())
    if s[0] == '-':
        break

    st = deque(s)

    tmp_st = deque([])
    cnt = 0
    while st:
        c = st.popleft()

        if c == '{':
            tmp_st.append(c)
        elif c == '}' and len(tmp_st) == 0:
            cnt += 1
            tmp_st.append('{')
        elif c == '}' and len(tmp_st) != 0:
            tmp_st.pop()

    if len(tmp_st) == 0:
        print(f"{flag}. {cnt}")
    else:
        print(f"{flag}. {int(len(tmp_st)) // 2 + cnt}")



