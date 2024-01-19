n = int(input())
for i in range(n):
    for j in range(n+i):
        if j <=n+i-1 and j >=n-i-1:
            print("*", end="")
        else:
            print(" ", end="")
    print()
n-=1
for i in range(n, 0, -1):
    for j in range(n+i):
        if j >n-i and j<n+i:
            print("*", end='')
        else:
            print(" ", end="")
    print()