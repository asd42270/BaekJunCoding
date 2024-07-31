import sys

n = int(sys.stdin.readline().rstrip())
matrix = []

for _ in range(n):
    r, c = map(int, sys.stdin.readline().split())
    matrix.append((r, c))

dp = [[0]*n for _ in range(n)] 
for i in range(n-1):
    dp[i][i+1] = matrix[i][0]*matrix[i+1][0]*matrix[i+1][1]

for L in range(2, n):    
    i = 0    
    j = L     
    while j < n:        
        dp[i][j] = 2**31        
        for k in range(i, j):            
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] +matrix[i][0]*matrix[k][1]*matrix[j][1])        
        i += 1        
        j += 1

print(dp[0][-1])
