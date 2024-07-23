import sys

def divide(n, square):
    if n==1:
        if square[0][0] == 1:
            return 0, 0, 1
        elif square[0][0] == 0:
            return 0, 1, 0
        else:
            return 1, 0, 0
    else:
        first = square[0][0]
        all_same=True
        for i in range(n):
            for j in range(n):
                if square[i][j] != first:
                    all_same = False
                    break
        
        if all_same:
            if square[0][0]==1:
                return 0, 0, 1
            elif square[0][0] == 0:
                return 0, 1, 0
            else:
                return 1, 0, 0
        else:
            triple1 = n//3
            triple2 = (n//3)*2
            minus1, zero1, one1 = divide(triple1, [row[:triple1] for row in square[:triple1]])
            minus2, zero2, one2 = divide(triple1, [row[triple1:triple2] for row in square[:triple1]])
            minus3, zero3, one3 = divide(triple1, [row[triple2:] for row in square[:triple1]])

            minus4, zero4, one4 = divide(triple1, [row[:triple1] for row in square[triple1:triple2]])
            minus5, zero5, one5 = divide(triple1, [row[triple1:triple2] for row in square[triple1:triple2]])
            minus6, zero6, one6 = divide(triple1, [row[triple2:] for row in square[triple1:triple2]])

            minus7, zero7, one7 = divide(triple1, [row[:triple1] for row in square[triple2:]])
            minus8, zero8, one8 = divide(triple1, [row[triple1:triple2] for row in square[triple2:]])
            minus9, zero9, one9 = divide(triple1, [row[triple2:] for row in square[triple2:]])

            return minus1+minus2+minus3+minus4+minus5+minus6+minus7+minus8+minus9, zero1+zero2+zero3+zero4+zero5+zero6+zero7+zero8+zero9, one1+one2+one3+one4+one5+one6+one7+one8+one9

n = int(sys.stdin.readline().rstrip())
square = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

minus, zero, one = divide(n, square)

print(minus)
print(zero)
print(one)