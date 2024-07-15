import sys

n, m = map(int, sys.stdin.readline().split())

numbers = [0]+list(map(int, sys.stdin.readline().split()))

dp = [0]*(n+1)

for i in range(1,m):
    dp[i] = dp[i-1] + numbers[i]

for i in range(m, n+1):
    dp[i] = dp[i-1] + numbers[i] - numbers[i-m]

print(max(dp[m:n+1]))