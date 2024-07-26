import sys

n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
start, end = 1, max(trees)
length = 0
while start <= end:
    mid = (start + end) // 2
    length = 0

    for tree in trees:
        if tree > mid:
            length += (tree - mid)

    if length >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)