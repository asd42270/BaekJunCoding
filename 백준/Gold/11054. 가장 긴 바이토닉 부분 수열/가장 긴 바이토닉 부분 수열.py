import sys

n = int(sys.stdin.readline().rstrip())
seq = list(map(int, sys.stdin.readline().split()))

LIS=[0]*n
LDS = [0]*n
dp = [0]*n

if n==1:
    print(1)
else:
    LIS[0]=1
    LDS[0]=1
    for i in range(1, n):
        LIS[i] = 1
        for j in range(i-1, -1, -1):
            if seq[j] < seq[i]:
                LIS[i] = max(LIS[i], LIS[j]+1)


    for i in range(n-1, -1, -1):
        LDS[i] = 1
        for j in range(n-1, i, -1):
            if seq[j] < seq[i]:
                LDS[i] = max(LDS[i], LDS[j]+1)

    for i in range(n):
        dp[i] = LIS[i] + LDS[i] -1

    print(max(dp))