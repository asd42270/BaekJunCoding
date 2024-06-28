import sys

count = 0
result = -1

def merge_sort(a, p, r, k):
    global result
    if p < r:
        q = (p+r)//2
        merge_sort(a, p, q, k)
        merge_sort(a, q+1, r, k)
        merge(a, p, q, r, k)

def merge(a, p, q, r, k):
    global count, result, tmp
    i, j, t = p, q+1, 0
    while i<=q and j<=r:
        if a[i]<=a[j]:
            tmp[t] = a[i]
            i+=1
        else:
            tmp[t] = a[j]       
            j+=1
        t+=1
        count+=1
        if count==k:
            result = tmp[t-1]

        

    while i<=q:
        tmp[t] = a[i]       
        t+=1
        i+=1
        count += 1
        if count == k:
            result = tmp[t - 1]
    
    while j<=r:
        tmp[t] = a[j]         
        t+=1
        j+=1
        count += 1
        if count == k:
            result = tmp[t - 1]
    
    i, t = p, 0

    while i<=r:
        a[i] = tmp[t]
        i+=1
        t+=1

n, k = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
tmp=[None] * len(a)
merge_sort(a, 0, n-1, k)

if result != -1:
    print(result)
else:
    print(-1)


