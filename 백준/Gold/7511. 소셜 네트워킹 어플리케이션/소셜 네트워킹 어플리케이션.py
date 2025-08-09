#

def find(x):
    if li[x] != x:
        li[x] = find(li[x])
    return li[x]
#
def union(a, b):
    a = find(a)
    b = find(b)
    if a!= b:
        li[b] = a

T = int(input())

for scenario_cnt in range(T):
    n= int(input())
    li = [i for i in range(n)]

    g = int(input())
    for _ in range(g):
        a, b = map(int, input().split())
        union(a, b)
    # print(li)

    h = int(input())
    answer = []
    for _ in range(h):
        a, b = map(int,input().split())
        x = find(a)
        y = find(b)
        if x == y:
            answer.append(1)
        else:
            answer.append(0)

    print("Scenario " + str(scenario_cnt + 1) + ":")
    for i in answer:
        print(i)
    print()




