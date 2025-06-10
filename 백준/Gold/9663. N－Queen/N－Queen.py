n = int(input())
ans = 0

row = [0] * n

def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False

    return True


def n_queens(x):
    global ans
    if x == n:
        ans += 1
        return

    for i in range(n):
        row[x] = i

        if is_promising(x):
            n_queens(x + 1)


n_queens(0)

print(ans)




### ⭐️ 문제에서 주로 사용한 알고리즘
# 백트래킹

### 간략한 코드 설명
# 체스판에 완전탐색 하면서 퀸을 하나씩 두고 재귀적으로 모든 경우의 수를 구하면 풀릴것 같다.
# 라고 생각했으나 재귀적으로 퀸을 둘 수 있는 곳인지 확인하는 조건문을 잘 만드는게 중요하다.
