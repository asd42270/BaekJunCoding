import sys

string = sys.stdin.readline().rstrip()

n = int(sys.stdin.readline().rstrip())
result=[]

for _ in range(n):
    a, l, r = map(str,sys.stdin.readline().split())
    result.append(string[int(l):int(r)+1].count(a))

for elem in result:
    print(elem)