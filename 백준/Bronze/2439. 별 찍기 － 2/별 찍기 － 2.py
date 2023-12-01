n = int(input())
for i in range(0, n):
    for j in range(0, n):
        if j < n-i-1:
            print(" ", end='')
        else:
            print("*", end='')
    print()