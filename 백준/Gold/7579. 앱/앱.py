import sys

# 정수의 개수 n과 필요한 메모리 m
n, m = map(int, sys.stdin.readline().split())

# 정수 배열
memory = [0] + list(map(int, sys.stdin.readline().split()))

# 비용 배열
cost  = [0] + list(map(int, sys.stdin.readline().split()))

# i까지의 앱에서 j만큼의 코스트로 얻을 수 있는 최대 메모리 값
dp = [[0 for _ in range(sum(cost)+1)] for _ in range(n+1)]  

# 필요한 메모리를 확보할 수 있는 최소 비용
result = int(1e9)

for i in range(1, n+1):
    byte = memory[i]
    pay = cost[i]  # costs 배열에서 값을 가져옵니다.
    for j in range(sum(cost)+1):
        # 현재의 cost가 더 크면, 이전 앱의 결과를 사용합니다.
        if j < pay:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-pay] + byte, dp[i-1][j])

        # 필요한 메모리를 확보할 수 있으면 최소 비용을 갱신합니다.
        if dp[i][j] >= m:
            result = min(result, j)

# 메모리를 확보하지 않아도 될 경우 처리
if m != 0:
    print(result)
else:
    print(0)
