#브루트 포스 - O(N^2)


N = int(input())
def is_doom(cur):
    # 6이 연속으로 최소 3번 등장하는지 체크
    text = str(cur)
    series6 = 0

    for i in range(len(text)):
        if text[i] == '6':
            series6 += 1
        else:
            series6 = 0

        if series6 == 3:
            return True
    return False

cur = 1
n_doom = 0

while True:
    if is_doom(cur) == True:
        n_doom += 1

    if n_doom == N:
        print(cur)
        break

    cur += 1
