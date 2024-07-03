
sdoku = []

#스도쿠 입력
for _ in range(9):
    row = list(map(int, input().split()))
    sdoku.append(row)

# 같은 행에 있는지
def row_valid(row, num):
    return num not in sdoku[row]

# 같은 열에 있는지
def col_valid(col, num):
    for i in range(9):
        if sdoku[i][col] == num:
            return False
    return True

# 3x3에서 유효한지
def square_valid(row, col, num):
    start_row = row // 3 * 3
    start_col = col // 3 * 3
    for i in range(3):
        for j in range(3):
            if sdoku[start_row + i][start_col + j] == num:
                return False
    return True

# 숫자가 유효한지 확인
def is_valid(row, col, num):
    return row_valid(row, num) and col_valid(col, num) and square_valid(row, col, num)

# 비어있는 셀 찾기
def find_empty():
    for i in range(9):
        for j in range(9):
            if sdoku[i][j] == 0:
                return (i, j)
    return None


# 스도쿠 해결
def solve():
    empty = find_empty()
    if not empty:
        return True  # 모든 셀이 채워진 경우
    row, col = empty

    for num in range(1, 10):
        if is_valid(row, col, num):
            sdoku[row][col] = num

            if solve():
                return True

            sdoku[row][col] = 0

    return False

# 스도쿠 풀기
if solve():
    for row in sdoku:
        print(" ".join(map(str, row)))
else:
    print("No solution exists")