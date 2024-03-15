n, m = map(int, input().split())
card = list(map(int, input().split()))
ans=[]
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            ans.append(card[i]+card[j]+card[k])
ans.append(m)
ans.sort()
for i in range(len(ans)):
    if ans[i]==m:
        if i==len(ans)-1:
            if ans[len(ans)-2] < m:
                print(ans[len(ans)-2])
                break
            else:
                print(ans[i])
                break
        else:
            if ans[i-1] == ans[i] or ans[i]==ans[i+1]:
                print(ans[i])
                break
            else:
                print(ans[i-1])
                break