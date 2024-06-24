from collections import deque
import sys

deq = deque()

num = int(sys.stdin.readline())
answer = []
for _ in range(num):
    order = sys.stdin.readline().split()
    if order[0]=="1":
        deq.appendleft(order[1])
    elif order[0]=="2":
        deq.append(order[1])
    elif order[0]=="3":
        if deq:
            answer.append(deq.popleft())
        else:
            answer.append(-1)
    elif order[0]=="4":
        if deq:
            answer.append(deq.pop())
        else:
            answer.append(-1)
    elif order[0]=="5":
        answer.append(len(deq))
    elif order[0]=="6":
        if deq:
            answer.append(0)
        else:
            answer.append(1)
    elif order[0]=="7":
        if deq:
            answer.append(deq[0])
        else:
            answer.append(-1)
    elif order[0]=="8":
        if deq:
            answer.append(deq[-1])
        else:
            answer.append(-1)

for elem in answer:
    print(elem)