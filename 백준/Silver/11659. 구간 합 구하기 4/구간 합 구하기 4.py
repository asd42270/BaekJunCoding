import sys

def cumulative_sum(n, number):
    cum_sum = [0]*n
    cum_sum[0] = number[0]
    for i in range(1,n):
        cum_sum[i] = number[i]+cum_sum[i-1]

    return cum_sum
n, m = map(int, sys.stdin.readline().split())

number = list(map(int, sys.stdin.readline().split()))
cum_sum = cumulative_sum(n, number)
result = []


for _ in range(m):
    i, j = map(int, sys.stdin.readline().split())
    cum_i = 0
    if i == 1:
        cum_i=0
    else:
        cum_i = cum_sum[i-2]
    result.append(cum_sum[j-1]-cum_i)

for elem in result:
    print(elem)