N = int(input())

paper = []
for _ in range(N):
    paper.append(list(map(int, input().split())))


def func(li, lj, ri, rj):
    # 종료조건
    if ri - li == 1:
        if paper[li][lj] == 0:
            return [1, 0]
        else:
            return [0, 1]

    # 모두 같은 색일때 종료
    first_value = paper[li][lj]
    is_consistent = True

    for i in range(li, ri):
        for j in range(lj, rj):
            if first_value != paper[i][j]:
                is_consistent = False
                break
        if not is_consistent:
            break

    if is_consistent:
        # 지금의 색을 더한다
        if first_value == 0:
            return [1, 0]
        else:
            return [0, 1]

    # 재귀 호출
    mi = (li + ri) // 2
    mj = (lj + rj) // 2

    res = [0, 0]
    # 4면을 호출한다
    # 데이터 통합
    rec1 = func(li, lj, mi, mj)
    rec2 = func(li, mj, mi, rj)
    rec3 = func(mi, lj, ri, mj)
    rec4 = func(mi, mj, ri, rj)

    # 0으로 된 개수 1로된 개수

    res[0] = rec1[0] + rec2[0] + rec3[0] + rec4[0]
    res[1] = rec1[1] + rec2[1] + rec3[1] + rec4[1]

    return res


res = func(0, 0, N, N)
print(res[0])
print(res[1])