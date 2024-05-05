import math
n = int(input())
lcms = []
for _ in range(n):
    a, b = map(int, input().split())
    lcms.append(math.lcm(a, b))

for lcm in lcms:
    print(lcm)