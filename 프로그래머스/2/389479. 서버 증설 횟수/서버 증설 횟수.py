# 서버 인원 캐파 : m , 서버 유지시간: k

def solution(players, m, k):
    answer = 0
    state = []
    for i in players:
        
        if i // m >= 1 and i//m > len(state):
            for _ in range(i//m - len(state)):
                state.append(k)
                answer += 1
        
        print(state)
        new_state = []
        for s in state:
            if s > 1:
                new_state.append(s - 1)
        state = new_state
    return answer









