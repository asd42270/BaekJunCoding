from collections import deque

n = int(input())

arr = deque([i for i in range(1, n+1)])

if len(arr) <=1:
    print(1)
else:
    while len(arr) > 1:
        arr.popleft()
        num = arr.popleft()
        arr.append(num)

    print(arr[0])
