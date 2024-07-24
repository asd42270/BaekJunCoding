import sys


def matrix_pow(matrix, b, n):
    if b == 1:
        result = [[0]*n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                result[i][j] = matrix[i][j]%1000
        return result
    elif b==2:
        return maxtrix_square(matrix, matrix, n)
    else:
        p = matrix_pow(matrix, b//2, n)
        if b%2==0:
            return maxtrix_square(p, p, n)
        else:
            return maxtrix_square(maxtrix_square(p, p, n), matrix, n)

# 행렬 곱셉(한 번 곱한 거니까 제곱) b가 2일때 이거지 b가 3이면?
def maxtrix_square(matrix, cal_matrix, n):
    result = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            elem = 0
            for k in range(n):
                elem += (matrix[i][k] * cal_matrix[k][j])
            result[i][j] = elem%1000
            
    return result    

n, b = map(int, sys.stdin.readline().split())
matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

result = matrix_pow(matrix, b, n)

for row in result:
    for col in row:
        print(col, end=" ")
    print()