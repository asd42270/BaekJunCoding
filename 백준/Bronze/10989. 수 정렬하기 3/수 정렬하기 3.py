import sys
input = sys.stdin.readline

n = int(input().lstrip().rstrip())
count=[0]*10001
for _ in range(n):
    count[int(input())]+=1

# count 배열을 이용하여 정렬된 결과를 출력
for i in range(len(count)):
    if count[i]>0:
        for _ in range(count[i]):
            print(i)