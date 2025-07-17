

def solution(a, b, g, s, w, t):
    def can(mid):
        total_gold = 0
        total_silver = 0
        total_weight = 0

        for i in range(len(g)):
            trips = mid // (2 * t[i])
            if mid % (2 * t[i]) >= t[i]:
                trips += 1

            max_carry = trips * w[i]

            gold_sent = min(g[i], max_carry)
            silver_sent = min(s[i], max_carry)
            total_sent = min(g[i] + s[i], max_carry)

            total_gold += gold_sent
            total_silver += silver_sent
            total_weight += total_sent
        return total_gold >= a and total_silver >= b and total_weight >= a + b

    left, right = 0, 10**15
    answer = right

    while left <= right:
        mid = (left + right) // 2
        if can(mid):
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer

