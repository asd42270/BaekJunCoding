def solution(order):
    answer = 0
    for drink in order:
        if drink in ["iceamericano", "americanoice", "americano", "anything", "hotamericano", "americanohot"]:
            answer+=4500
        else:
            answer+=5000
    return answer