n = int(input())
arr=[]
for i in range(n):
    [x, y] = map(int, input().split())
    arr.append([x,y])

sorted_arr = sorted(arr, key=lambda x: (x[0], x[1]))
for elem in sorted_arr:
    for data in elem:
        print(data, end=" ")
    print()