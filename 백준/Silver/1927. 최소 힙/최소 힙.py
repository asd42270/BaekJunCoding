import heapq
import sys

heap = []
result = []

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    x = int(sys.stdin.readline().rstrip())
    if x == 0:
        if len(heap) == 0:
            result.append(0)
        else:
            result.append(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)

for elem in result:
    print(elem)