n, m = map(int, input().split())
matrix=[]
plus=[]
for _ in range(n):
    row=list(map(int, input().split()))
    matrix.append(row)
        
for _ in range(n):
    plusrow=list(map(int, input().split()))
    plus.append(plusrow)

for i in range(n):
    for j in range(m):
        matrix[i][j]+=plus[i][j]
        print(matrix[i][j], end=' ')
    print()