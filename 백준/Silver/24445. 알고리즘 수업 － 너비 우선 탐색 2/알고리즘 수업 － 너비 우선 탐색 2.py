from collections import deque 
import sys

def bfs(graph, start_v, visited):
    global count
    visited[start_v] = count
    queue = deque([start_v])
    while queue:
        cur_v = queue.popleft()
        for vertex in graph[cur_v]:
            if visited[vertex] == 0:
                count+=1
                visited[vertex] = count
                queue.append(vertex)

n, m, r = map(int, sys.stdin.readline().split())

visited=[0]*(n+1)
graph =[[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n+1):
    graph[i].sort(reverse=True)

count = 1
bfs(graph,r, visited)

for i in range(1, n+1):
    print(visited[i])