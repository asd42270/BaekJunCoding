t  = int(input())
p = [0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9] + [0 for _ in range(90)]
arr=[]

for i in range(11, 101):
    p[i] = p[i-2]+p[i-3]

for _ in range(t):
    n = int(input())
    arr.append(p[n])

for elem in arr:
    print(elem)