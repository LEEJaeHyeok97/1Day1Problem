def solution(numlist, n):
    return sorted(numlist, key = lambda x : (abs(n - int(x)), n - int(x))) # n과의 거리 순으로 정렬 후, 거리 절댓값이 같다면 더 큰 x 값이 먼저 오도록 정렬