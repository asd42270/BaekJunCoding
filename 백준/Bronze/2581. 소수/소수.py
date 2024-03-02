m = int(input())
n = int(input())
arr=[]
for i in range(m, n+1):
    arr.append(i)
sum=0
for i in range(m, n+1):
    if i==1:
        arr.remove(i)
    for j in range(2, i):
        if i%j==0:
            arr.remove(i)
            break
if arr:
    for elem in arr:
        sum+=elem
    arr.sort()
    print(sum)
    print(arr[0])
else:
    print(-1)