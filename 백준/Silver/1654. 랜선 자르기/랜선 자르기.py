import sys

k, n = map(int, sys.stdin.readline().split())

lan = [int(sys.stdin.readline().rstrip()) for _ in range(k)]
start, end = 1, max(lan) #이분탐색 처음과 끝위치

while start <=end:
    mid = (start + end) // 2
    cnt = 0
    for line in lan:
        cnt += line // mid
    
    if cnt >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)