def findIndex(arr, number):
    for i in range(5):
        for j in range(5):
            if arr[i][j] == number:
                return i, j


answerSheet = [[0, 0, 0, 0, 0] for _ in range(5)]
bingo_cnt = 0
cnt = 0

bingo = []
numbers = []
for _ in range(5):
    row = list(map(int, input().split()))
    bingo.append(row)

for _ in range(5):
    row = list(map(int, input().split()))
    numbers.append(row)

for i in range(5):
    for j in range(5):
        if bingo_cnt >= 3:
            break

        row, col = findIndex(bingo, numbers[i][j])
        answerSheet[row][col] = 1
        cnt+=1


        if all(answerSheet[row][i] == 1 for i in range(5)):
            bingo_cnt+=1

        if all(answerSheet[i][col] == 1 for i in range(5)):
            bingo_cnt+=1
        
        if row == col and all(answerSheet[i][i] == 1 for i in range(5)):
            bingo_cnt+=1
            
        if row+col == 4 and all(answerSheet[4-i][i] == 1 for i in range(5)):
            bingo_cnt+=1

print(cnt)