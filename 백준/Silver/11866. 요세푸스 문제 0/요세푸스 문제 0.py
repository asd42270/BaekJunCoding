from collections import deque

n, k = map(int, input().split())

arr = deque([i for i in range(1, n+1)])
answer = []
index = (k-1)%len(arr)
while len(arr) > 1:
    num = arr[index]
    arr.remove(num)
    answer.append(num)
    index = (index+k-1)%len(arr)

answer.append(arr[0])

print("<", end='')
for elem in answer:
    if elem == answer[-1]:
        print(f"{elem}>", end="")
    else:
        print(f"{elem}, ",end="")
