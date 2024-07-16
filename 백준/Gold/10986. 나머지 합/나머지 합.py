import sys

n, m = map(int, sys.stdin.readline().split())

nums = list(map(int, sys.stdin.readline().split()))
dp = [0]*m
dp[0]=1
prefix_sum=0

for i in range(n):
    prefix_sum+=nums[i]
    dp[prefix_sum%m]+=1

cnt=0
for i in dp:
    cnt+=i*(i-1)//2

print(cnt)