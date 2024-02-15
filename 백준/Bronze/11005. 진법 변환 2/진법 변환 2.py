arr=[]
n, b = map(int, input().split())
while True:
    if n==b:
        if (n%b)>=10:
            arr.append(chr(n%b+55))
        else:
            arr.append(n%b)
        if (n//b) >=10:
            arr.append(chr(n//b+55))
        else:
            arr.append(n//b)
        break
    if (n%b)>=10:
        arr.append(chr(n%b+55))
    else:
        arr.append(n%b)
    n = n//b
    if n==0:
        break
for i in range(len(arr)-1, -1, -1):
    print(arr[i], end='')