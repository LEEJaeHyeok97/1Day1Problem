def split_file(f):
    n = len(f)
    i = 0
    
    while i < n and not f[i].isdigit():
        i += 1
    head_end = i
    
    j = i
    count = 0
    while j < n and f[j].isdigit() and count < 5:
        j += 1
        count += 1
    number_end = j
    
    head = f[:head_end]
    number = f[head_end:number_end]
    tail = f[number_end:]
    return head, number, tail
    
    

def solution(files):
    parsed = []
    for idx, v in enumerate(files):
        head, number, tail = split_file(v)
        parsed.append((head.lower(), int(number), idx, v))
    parsed.sort(key=lambda x: (x[0], x[1], x[2]))
    return [x[3] for x in parsed]