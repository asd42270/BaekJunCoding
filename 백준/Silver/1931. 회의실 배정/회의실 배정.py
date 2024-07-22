import sys

n = int(sys.stdin.readline().rstrip())

scrum_time = []
for _ in range(n):
    start, end = map(int, sys.stdin.readline().split())
    scrum_time.append((start, end))

scrum_time.sort(key=lambda x:(x[1],x[0]))

if n ==1:
    print(1)
else:

    cnt=1
    k = scrum_time[0][1]
    for i in range(1,n):
        if scrum_time[i][0]>=k:
            cnt+=1
            k = scrum_time[i][1]

    print(cnt)