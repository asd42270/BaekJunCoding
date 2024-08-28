def solution(n):
    answer = []
    i = 1
    while n > 0:
        answer.append(n%3)
        n = n//(3)

    ans, j = 0, 0
    for i in range(len(answer)-1, -1, -1):
        number = (3**j)*answer[i]
        j+=1
        ans +=number
        
    return ans