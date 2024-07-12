import sys

n, k = map(int, sys.stdin.readline().split())

knapsack = [[0, 0]]
dp = [[0 for _ in range(k+1)] for _ in range(n+1)]


for _ in range(n):
    knapsack.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, n+1):
    w = knapsack[i][0]
    v = knapsack[i][1]

    for j in range(1, k+1):
        if j < w:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)

print(dp[n][k])