from collections import deque
import sys
n = int(sys.stdin.readline())
stack = deque()
result=[]
for _ in range(n):
    arr = list(map(int,sys.stdin.readline().split()))
    if len(arr)==2:
        stack.append(arr[1])
    else:
        if arr[0]==2:
            if len(stack)>0:
                result.append(stack.pop())
            else:
                result.append(-1)
        elif arr[0]==3:
            result.append(len(stack))
        elif arr[0]==4:
            if len(stack)>0:
                result.append(0)
            else:
                result.append(1)
        elif arr[0]==5:
            if len(stack)>0:
                result.append(stack[-1])
            else:
                result.append(-1)

for elem in result:
    print(elem)