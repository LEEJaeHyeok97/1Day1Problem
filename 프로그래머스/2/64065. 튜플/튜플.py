# 튜플 = 셀수 있는 수량의 순서 있는 열거 또는 순서따르는 요소모음
# n개요소 가지는 튜플 = n-튜플
# 중복된 원소 가능, 원소에 정해진 순서가 있음. 순서가 다르면 다른 튜플
# 집합은 원소의 순서가 바뀌어도 상관 없음. 
# 문자열 s가 집합이 담긴 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return하시오
# 5<=len(s) <= 10^6 

def solution(s):
    li = s[1:-1].split("},")
    new_li = []
    for i in li:
        k = i.replace("{", "")
        k = k.replace("}", "")
        new_li.append(k)
            
    # print(new_li)
    li = []
    for i in new_li:
        li.append(list(map(int, i.split(','))))
    # print(li)
    
    ans = []
    li = sorted(li, key= lambda x: len(x))
    # print(li)
    for i in li:
        for j in i:
            if j not in ans:
                ans.append(j)
    
    return ans






