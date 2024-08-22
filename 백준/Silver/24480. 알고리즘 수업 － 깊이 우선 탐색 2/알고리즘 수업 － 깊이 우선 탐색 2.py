import sys

sys.setrecursionlimit(10**6)

def dfs(cur_vertex):
    global count
    ordered[cur_vertex] = count
    count+=1
    for vertex in graph[cur_vertex]:
        if ordered[vertex]==0:
            dfs(vertex)

n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
ordered = [0] * (n+1)
for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n+1):
    graph[i].sort(reverse=True)

count = 1
dfs(r)

for i in range(n+1):
    if i!=0:
        print(ordered[i])