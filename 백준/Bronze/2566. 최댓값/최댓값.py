grid = []
max_grid=0
row, col = 0, 0
for _ in range(9):
    grid.append(list(map(int, input().split())))
 
for i in range(9):
    for j in range(9):
        if grid[i][j] > max_grid:
            max_grid=grid[i][j]
            row, col = i, j
print(max_grid)
print(row+1, col+1)