import sys

n, m, k = map(int, sys.stdin.readline().split())
chess = [sys.stdin.readline().strip() for _ in range(n)]

def min_paint_cost(chess, n, m, k):
    prefix_black = [[0] * (m + 1) for _ in range(n + 1)]
    prefix_white = [[0] * (m + 1) for _ in range(n + 1)]

    for i in range(n):
        for j in range(m):
            if (i + j) % 2 == 0:
                is_black = 1 if chess[i][j] == 'B' else 0
                is_white = 1 if chess[i][j] == 'W' else 0
            else:
                is_black = 1 if chess[i][j] == 'W' else 0
                is_white = 1 if chess[i][j] == 'B' else 0
            
            prefix_black[i + 1][j + 1] = prefix_black[i + 1][j] + prefix_black[i][j + 1] - prefix_black[i][j] + is_black
            prefix_white[i + 1][j + 1] = prefix_white[i + 1][j] + prefix_white[i][j + 1] - prefix_white[i][j] + is_white
    
    min_cost = float('inf')
    
    for i in range(n - k + 1):
        for j in range(m - k + 1):
            x1, y1 = i, j
            x2, y2 = i + k, j + k
            
            total_black = prefix_black[x2][y2] - prefix_black[x1][y2] - prefix_black[x2][y1] + prefix_black[x1][y1]
            total_white = prefix_white[x2][y2] - prefix_white[x1][y2] - prefix_white[x2][y1] + prefix_white[x1][y1]
            
            min_cost = min(min_cost, total_black, total_white)
    
    return min_cost

print(min_paint_cost(chess, n, m, k))
