arr = list(map(int, input().split()))
arr.sort()
if arr[0]==arr[2] :
    print(10000+(arr[0]*1000))
elif arr[0]==arr[1] or arr[1]==arr[2]:
    if arr[0]==arr[1]:
        print(1000+ (arr[0]*100))
    else:
        print(1000+(arr[1]*100))
else:
    print(arr[2]*100)