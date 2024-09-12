s = input()

explode = input()
m = len(explode)

st = []

for i in s:
    st.append(i)
    if ''.join(st[len(st) - m:]) == explode:
        for _ in range(m):
            st.pop()

if st:
    for i in st:
        print(i, end='')
else:
    print("FRULA")
