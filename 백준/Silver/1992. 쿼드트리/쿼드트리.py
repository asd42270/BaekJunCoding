import sys

def divide(n, square):
    if n==1:
        if square[0][0] == 1:
            return str(1)
        else:
            return str(0)
    else:
        all_same=True
        for i in range(n):
            for j in range(n):
                if square[i][j] != square[0][0]:
                    all_same = False
                    break
        
        if all_same:
            if square[0][0]==1:
                return str(1)
            else:
                return str(0)
        else:
            half = n//2
            result1 = divide(half, [row[:half] for row in square[:half]])
            result2 = divide(half, [row[half:] for row in square[:half]])
            result3 = divide(half, [row[:half] for row in square[half:]])
            result4 = divide(half, [row[half:] for row in square[half:]])
            return "("+result1+result2+result3+result4+")"


n = int(sys.stdin.readline().rstrip())
square = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]

print(divide(n, square))