N = int(input())

li = []
for i in range(N):
    command = input().split()
    
    if command[0] == 'push_back':
        li.append(command[1])
    if command[0] == 'pop_back':
        li = li[:-1]
    if command[0] == 'size':
        print(len(li))
    if command[0] == 'get':
        tmp = int(command[1]) - 1
        print(li[tmp])