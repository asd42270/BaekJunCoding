from itertools import product
import sys

n, m = map(int, sys.stdin.readline().split())

arr = [i for i in range(1,n+1)]

result = list(product(arr, repeat=m))

for elems in result:
    for elem in elems:
        print(elem, end=" ")
    print()

