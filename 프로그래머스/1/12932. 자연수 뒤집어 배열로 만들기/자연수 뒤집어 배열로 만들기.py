from collections import deque
def solution(n):
    answer = deque()
    for row in str(n):
        answer.appendleft(int(row))
    
    real = []
    for row in answer:
        real.append(row)
    return real