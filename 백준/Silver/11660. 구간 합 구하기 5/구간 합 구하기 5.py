import sys

n, m = map(int, sys.stdin.readline().split())

table = []

for _ in range(n):
    table.append(list(map(int, sys.stdin.readline().split())))

for row in table:
    for i in range(1, n):
        row[i]+=row[i-1]

def get_range_sum(x1, y1, x2, y2):
    total_sum = 0
    for i in range(x1, x2+1):
        if y1==0:
            total_sum+=table[i][y2]
        else:
            total_sum+=(table[i][y2] - table[i][y1-1])
    return total_sum

question = []
for _ in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    question.append((x1-1, y1-1, x2-1, y2-1))

for x1, y1, x2, y2 in question:
    print(get_range_sum(x1, y1, x2, y2))