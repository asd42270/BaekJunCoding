a1, a0 = map(int, input().split())
c= int(input())
n0 = int(input())
if c-a1==0:
    if a0 <0:
        print(1)
    else:
        print(0)
elif c-a1<0: 
    print(0)
else:
    a = a0/(c-a1)
    if n0 >= a:
        print(1)
    else:
        print(0)