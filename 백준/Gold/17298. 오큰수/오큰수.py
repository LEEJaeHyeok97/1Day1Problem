N = int(input())

li = list(map(int, input().split()))

NGE = [-1] * N

st = []

for i, v in enumerate(li):
    while st and li[st[-1]] < v:
        NGE[st.pop()] = v
    st.append(i)
print(*NGE)