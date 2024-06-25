import sys
import math

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
if n==1:
      print(arr[0]**2)
else:
    arr.sort()
    print(arr[0]*arr[-1])