def solution(myString):
    answer = myString.replace('x', " ").split()

    return sorted(answer)