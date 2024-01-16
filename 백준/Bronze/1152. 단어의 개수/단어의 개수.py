arr = list(input().split())
cnt = 0
for word in arr:
    if word == ' ':
        continue
    else:
        cnt+=1
print(cnt)