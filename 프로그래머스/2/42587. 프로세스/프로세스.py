# 특정 프로세스가 몇 번째로 실행되는지 알아내야 한다.
# 운영체제 규칙.
# 1. 실행 대기 큐Queue에서 대기중인 프로세스 하나를 꺼낸다.
# 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에
# 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행
# 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료
# 우선 순위는 값이 높을 수록 높다.
# 1<= priorities <= 100
from collections import deque
def solution(priorities, location):
    if len(priorities) == 1:
        return 1
    priorities = deque(list(priorities))
    process = [i for i in range(len(priorities))]
    process = deque(process)
    # print(process)
    # print(priorities)
    # answer = 0
    flag = False
    cnt = 0
    while priorities:
        # print(p)
        if flag == True:
            break
        p = priorities.popleft()
        proc = process.popleft()
        if priorities and max(priorities) > p:
            priorities.append(p)
            process.append(proc)
        else:
            cnt += 1
            if location == proc:
                flag = True
    
    return cnt





