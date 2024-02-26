n = int(input())
i=1
fsum, bsum=1, 1 
while True:
    if fsum<=n and n<=bsum:
        print(i)
        break
    else:
        if i==1:
            fsum=2
            bsum=bsum+6*i
            i+=1
            continue
        else:
            fsum=fsum+6*(i-1)
            bsum=bsum+6*i
            i+=1
            continue