N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

B.sort()

A.sort(reverse=True)

# print(A)
# print(B)

ans = []
for i in range(len(A)):
    tmp = A[i] * B[i]
    ans.append(tmp)
print(sum(ans))