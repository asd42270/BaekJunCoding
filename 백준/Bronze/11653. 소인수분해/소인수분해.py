num=int(input())
i=2
while True:
    if num==1:
        break
    if num%i!=0:
        i+=1
    else:
        num=num//i
        print(i)
        i=2
        ans=1
        for j in range(2,num):
            if num%j==0:
                ans-=1
                break
            else:
                continue
        if ans==1:
            if num==1:
                break
            print(num)
            break