def solution(intStrs, k, s, l):
    answer = []
    for ints in intStrs:
        if int(ints[s:s+l]) > k:
            answer.append(int(ints[s:s+l]))
    return answer