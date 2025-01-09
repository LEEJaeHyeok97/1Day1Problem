S = input()
T = input()

reverse_T = T[::-1]

while len(S) != len(reverse_T):
    if str(reverse_T)[0] == 'A':
        reverse_T = reverse_T[1:]
    else:
        reverse_T = reverse_T[1:]
        reverse_T = reverse_T[::-1]

reverse_T = reverse_T[::-1]
if S == reverse_T:
    print(1)
else:
    print(0)