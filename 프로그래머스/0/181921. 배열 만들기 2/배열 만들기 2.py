def solution(l, r):
    answer = []
    
    number = ['0', '5']
    
    for i in range(l, r+1):
        now = str(i)
        now_in = True
        for j in now:
            if j not in number:
                now_in = False
                break
        if now_in == True:
            answer.append(i)
    
    if answer:
        return answer
    else:
        return [-1]

 