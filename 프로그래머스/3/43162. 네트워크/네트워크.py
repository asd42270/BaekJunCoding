from collections import deque
def solution(n, computers):
    answer = 0
    visited = [False] * n 
    for i in range(n):
        if visited[i]==0:
            bfs(i, computers, visited, n)
            answer+=1
    return answer

def bfs(networkNum, computers, visited, n):
    queue = deque()
    queue.append(networkNum)
    visited[networkNum] = True
    while queue:
        num = queue.popleft()
        for i in range(n):
            if visited[i]==False and computers[num][i] == 1:
                visited[i] = True
                queue.append(i)