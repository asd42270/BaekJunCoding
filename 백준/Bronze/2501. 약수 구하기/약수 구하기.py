arr=[]
n, k = map(int, input().split())
for i in range(1, n+1):
    if n%i==0:
        arr.append(n//i)
    else:
        continue
arr.reverse()
if k <= len(arr):
    print(arr[k-1])
else:
    print(0)
