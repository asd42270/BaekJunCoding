import sys

n, c = map(int, sys.stdin.readline().split())

coordinate = []
for _ in range(n):
    coordinate.append(int(sys.stdin.readline().rstrip()))

coordinate.sort()

# 공유기 거리를 기준으로 이진탐색을 진행
start, end = 1, coordinate[-1] - coordinate[0]
result = 0
while start<=end:
    mid = (start+end)//2
    current = coordinate[0]
    cnt = 1

    for i in range(1, n):
        if coordinate[i] >= current+mid:
            cnt +=1
            current = coordinate[i]
    
    if cnt >= c:
        start = mid+1
        result = mid
    else:
        end = mid-1

print(result)