def solution(myString, pat):
    answer = 0
    for i in range(len(myString)):
        if pat in myString[i:i+len(pat)]:
            answer+=1
    return answer