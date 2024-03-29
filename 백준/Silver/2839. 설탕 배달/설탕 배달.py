n = int(input())
three, five = 0, 0

if n<=6:
    if n%3!=0:
        if n==5:
            print(1)
        else:
            print(-1)
    else:
        print(n//3)
else:
    if n%5==1:
            five+=((n-6)//5)
            three+=2
            print(five+three)
    elif n%5==2:
        if n >=12:
              five+=((n-12)//5)
              three+=4
              print(five+three)
        else:
             print(-1)
    elif n%5==3:
        five+=((n-3)//5)
        three+=1
        print(five+three)
    elif n%5==4:
        five+=((n-9)//5)
        three+=3
        print(five+three)
    else:
        print(n//5)
