import sys

def cal_score(board, visited):
    star_team = []
    link_team = []

    for i in range(n):
        if visited[i]:
            star_team.append(i)
        else:
            link_team.append(i)

    star_score = 0
    link_score = 0            

    for i in range(n // 2):
        for j in range(n // 2):
            if i != j:
                star_score += board[star_team[i]][star_team[j]]
                link_score += board[link_team[i]][link_team[j]]
    
    return abs(star_score - link_score)
    

def set_team(idx, count, visited):
    global min_diff
    
    if count == n // 2:
        min_diff = min(min_diff, cal_score(score_board, visited))
        return
    
    for i in range(idx, n):
        if not visited[i]:
            visited[i] = True
            set_team(i + 1, count + 1, visited)
            visited[i] = False

n = int(sys.stdin.readline())
score_board = []
for i in range(n):
    board= list(map(int, sys.stdin.readline().split()))
    score_board.append(board)

min_diff = 100

visited = [False] * n
set_team(0, 0, visited)
print(min_diff)