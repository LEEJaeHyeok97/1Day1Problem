chemical = input()

stack = []

atom = {'H': 1, 'C': 12, 'O': 16}

for c in chemical:
    if c == '(':
        stack.append(c)
    elif c == 'H' or c == 'C' or c == 'O':
        stack.append(atom[c])
    elif c == ')':
        temp = 0
        while True:
            if stack[-1] == '(':
                stack.pop()
                stack.append(temp)
                break
            else:
                temp += stack.pop()
    else:
        stack.append(stack.pop()*int(c))
print(sum(stack))