num = int(input())
arr=[]
for i in range(num):
    sum=0
    for j in str(i):
        sum+=int(j)
    sum+=i
    if sum == num:
        arr.append(i)
if len(arr)>0:
    print(min(arr))
else:
    print(0)