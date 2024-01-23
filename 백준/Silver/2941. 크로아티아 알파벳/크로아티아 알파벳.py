word = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt, i = 0, 0
while(i <=len(word)-1):
    if word[i:i+2] in croatia:
        cnt+=1
        i+=2
    elif word[i:i+3] in croatia:
        cnt+=1
        i+=3
    else:
        i+=1
        cnt+=1

print(cnt)