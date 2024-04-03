import sys
input = sys.stdin.readline

n = input()
arr=[]
for elem in n:
    arr.append(elem)

arr.sort(reverse=True)
for elem in arr:
    print(elem, end="")