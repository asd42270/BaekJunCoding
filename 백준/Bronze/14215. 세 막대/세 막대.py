arr = list(map(int, input().split()))
arr.sort()
max=0
while True:
    if arr[0]+arr[1] > arr[2]:
        print(arr[0]+arr[1]+arr[2])
        break
    else:
        max = arr[2]-1
        arr[2] = max
        if arr[0]+arr[1] > arr[2]:
            print(arr[0]+arr[1]+arr[2])
            break
