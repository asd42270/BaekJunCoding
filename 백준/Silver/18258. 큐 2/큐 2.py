from collections import deque
import sys

deq = deque()

num = int(sys.stdin.readline())
result=[]

for _ in range(num):
    command = sys.stdin.readline().split()

    if command[0] == "push":
        deq.append(int(command[1]))
    
    elif command[0] == "pop":
        if len(deq) > 0:
            result.append(deq.popleft())
        else:
            result.append(-1)
    
    elif command[0] == "size":
        result.append(len(deq))
    
    elif command[0] == "empty":
        if len(deq) > 0:
            result.append(0)
        else:
            result.append(1)

    elif command[0] == "front":
        if len(deq) > 0:
            result.append(deq[0])
        else:
            result.append(-1)

    elif command[0] == "back":
        if len(deq) > 0:
            result.append(deq[-1])
        else:
            result.append(-1)

for elem in result:
    print(elem)               