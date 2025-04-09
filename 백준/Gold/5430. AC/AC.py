# AC: 정수 배열 연산 언어
# R: 배열에 있는 수의 순서를 뒤집는다
# D: 첫 번째 수를 버린다.(배열이 비어있으면 에러 발생)

from collections import deque

T = int(input())

for i in range(T):
    command = input()
    li_length = int(input())
    t = input()[1:-1]

    if li_length == 0:
        edited_li = deque([])
    else:
        edited_li = deque(t.split(','))

    # print(edited_li)

    is_error = False
    flag = 0
    for c in command:
        # print(c)
        if c == 'R':
            if flag == 0:
                flag = 1
            else:
                flag = 0
        elif c == 'D':
            if len(edited_li) == 0:
                is_error = True
                break
            elif flag == 1:
                edited_li.pop()
            elif flag == 0:
                edited_li.popleft()

    if is_error:
        print("error")
        continue
    else:
        if flag == 1:
            edited_li.reverse()
    print("[" + ",".join(edited_li) + "]")
