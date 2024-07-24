import sys

n, m = map(int, sys.stdin.readline().split())
matrix_a = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

m, k = map(int, sys.stdin.readline().split())
matrix_b = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]


result = []

for row in matrix_a:
    for j in range(k):
        elem = 0
        for i in range(m):
            elem+=row[i] * matrix_b[i][j]
        result.append(elem)

cnt = 0

for elem in result:
    print(elem, end=" ")
    cnt+=1
    if cnt%k==0:
        print()