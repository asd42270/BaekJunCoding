h, m = map(int, input().split())
time = int(input())
if (m+time)%60==0:
    a = (m+time)//60 
    if h==23:
        print(0+a-1, 0)
    else:
        if h+a>23:
            print((h+a)-24,0)
        else:
            print(h+a, 0)
else:
    a, b = (m+time)//60, (m+time)%60
    if h==23:
        print(0+a-1, b)
    else:
        if h+a>23:
            print((h+a)-24, b)
        else:
            print(h+a, b)    