import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n, m, r = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
cnt = 1

for i in range(m):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)
    
for i in range(n+1):
    graph[i].sort()

def dfs(graph, v, visited):
    global cnt
    visited[v] = cnt
    for i in graph[v]:
        if visited[i] == 0:
            cnt += 1
            dfs(graph, i, visited)
dfs(graph, r, visited)

for i in range(n+1):
    if i != 0:
        print(visited[i])