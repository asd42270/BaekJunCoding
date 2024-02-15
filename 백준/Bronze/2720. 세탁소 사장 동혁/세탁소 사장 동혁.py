t = int(input())
arr1 = []
for _ in range(t):
    c = int(input())
    q= c//25
    d = (c%25)//10
    n = ((c%25)%10)//5
    p = ((c%25)%10)%5
    arr1.append([q, d, n, p])

for arr2 in arr1:
    for elem in arr2:
        print(elem, end=' ')
    print()