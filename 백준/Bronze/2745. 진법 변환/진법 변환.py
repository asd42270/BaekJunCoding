n, b = map(str, input().split())
cnt=0
total=0
for i in range(len(n)-1, -1, -1):
    if (n[i].isdigit()):
        total+=int(n[i])*(pow(int(b), cnt))
        cnt+=1
    else:
        total+=(ord(n[i])-55)*(pow(int(b), cnt))
        cnt+=1
print(total)