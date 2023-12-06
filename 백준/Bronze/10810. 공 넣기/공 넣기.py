n, m = map(int, input().split())
arr = [-1 for _ in range(n)]
for _ in range(m):
    i, j, k = map(int, input().split())
    for h in range(i-1, j):
        arr[h] = k
for elem in arr:
    if elem!=-1:
        print(elem, end=' ')
    else:
        print(0, end=' ')
        