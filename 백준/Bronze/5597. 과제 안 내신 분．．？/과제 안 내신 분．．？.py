arr = [i for i in range(1, 31)]
for _ in range(28):
    n = int(input())
    arr.remove(n)
        
arr.sort()
for elem in arr:
    print(elem)