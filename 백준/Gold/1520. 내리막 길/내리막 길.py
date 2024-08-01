import sys

m, n = map(int, sys.stdin.readline().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

dp = [[-1]*n for _ in range(m)]


def dfs(x, y):
    if x == m-1 and y==n-1:
        return 1

    if dp[x][y] != -1:
        return dp[x][y]

    dp[x][y] = 0

    for i in range(4):
        newx = x + dx[i]
        newy = y + dy[i]
        if 0 <= newx < m and 0 <= newy < n:
            if maps[newx][newy] < maps[x][y]:
                dp[x][y] += dfs(newx, newy)
    return dp[x][y] 

print(dfs(0,0))