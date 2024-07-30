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
            result.append(heapq.heappop(heap)[1])
    else:
        # 최대 힙을 만들자
        heapq.heappush(heap, (-x, x))


for elem in result:
    print(elem)