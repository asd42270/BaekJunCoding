import sys

n = int(sys.stdin.readline().strip())
names = set()
count = 0
for _ in range(n):
    log = sys.stdin.readline().strip()
    if log == "ENTER":
        names = set()
    else:
        if log not in names:
            names.add(log)
            count+=1

print(count)