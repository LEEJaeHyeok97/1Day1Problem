secret = str(input())

N = int(input())

diction = []

for i in range(N):
    diction.append(str(input()))

alpha = 'abcdefghijklmnopqrstuvwxyza'
index = 0
answer = ''

while True:
    new_secret = ''
    for i in secret:
        index = alpha.index(i)
        new_secret += alpha[index + 1]
        secret = new_secret

    for d in diction:
        if d in secret:
            answer = secret

    if len(answer):
        break

print(answer)