import sys

def matrix_pow(matrix, n, size):
    if n == 1:
        result = [[0]*size for _ in range(size)]
        for i in range(size):
            for j in range(size):
                result[i][j] = matrix[i][j]%1000000007
        return result
    elif n == 2:
        return matrix_mul(matrix, matrix, size)
    else:
        p = matrix_pow(matrix, n//2, size)
        if n%2==0:
            return matrix_mul(p, p, size)
        else:
            return matrix_mul(matrix_mul(p, p, size), matrix, size)
        
def matrix_mul(matrix, cal_matrix, size):
    result = [[0]*size for _ in range(size)]

    for i in range(size):
        for j in range(size):
            elem = 0
            for k in range(size):
                elem += (matrix[i][k] * cal_matrix[k][j])
            result[i][j] = elem%1000000007
            
    return result    

n = int(sys.stdin.readline().rstrip())

matrix = [[1, 1],[1, 0]]

result = matrix_pow(matrix, n, 2)

print(result[0][1])