import sys

n = int(sys.stdin.readline().rstrip())
road = list(map(int, sys.stdin.readline().split()))
oil_cost = list(map(int, sys.stdin.readline().split()))

total_cost = oil_cost[0] * road[0]
low_cost = 9999999999999999999
for i in range(1, n-1):
    if oil_cost[i] <= low_cost:
        total_cost+= (oil_cost[i]*road[i])
        low_cost = oil_cost[i]
    else:
        total_cost+=(low_cost*road[i])

print(total_cost)