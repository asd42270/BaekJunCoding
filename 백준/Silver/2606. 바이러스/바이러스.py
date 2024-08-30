import sys

def dfs(start_v):
    visited.append(start_v)

    for vertex in graph[start_v]:
        if  vertex not in visited:
            dfs(vertex)


n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(n+1)]
visited=[]
cnt = 0

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

dfs(1)
print(len(visited)-1) 