import sys

def divide(n, square):
    if n == 1:
        if square[0][0] == 1:
            return 0, 1  # 흰색 0, 파란색 1
        else:
            return 1, 0  # 흰색 1, 파란색 0

    # 현재 사각형의 색이 모두 같은지 확인
    color = square[0][0]
    all_same = True
    for i in range(n):
        for j in range(n):
            if square[i][j] != color:
                all_same = False
                break
        if not all_same:
            break

    if all_same:
        if color == 1:
            return 0, 1  # 흰색 0, 파란색 1
        else:
            return 1, 0  # 흰색 1, 파란색 0

    # 네 개의 부분으로 나누어 재귀 호출
    half = n // 2
    square1 = [row[:half] for row in square[:half]]
    square2 = [row[half:] for row in square[:half]]
    square3 = [row[:half] for row in square[half:]]
    square4 = [row[half:] for row in square[half:]]

    white1, blue1 = divide(half, square1)
    white2, blue2 = divide(half, square2)
    white3, blue3 = divide(half, square3)
    white4, blue4 = divide(half, square4)
    
    return (white1 + white2 + white3 + white4, blue1 + blue2 + blue3 + blue4)

n = int(sys.stdin.readline().rstrip())
square = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

white, blue = divide(n, square)
print(white)
print(blue)
