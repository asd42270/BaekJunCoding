import sys

n = int(sys.stdin.readline().rstrip())
stair_score = [0]
for _ in range(n):
    stair_score.append(int(sys.stdin.readline().rstrip()))

# 기본적으로 dp 배열의 크기를 n+1로 초기화
dp = [0] * (n + 1)

# 경계 조건 처리
if n == 1:
    print(stair_score[1])
elif n == 2:
    print(stair_score[1] + stair_score[2])
else:
    dp[1] = stair_score[1]
    dp[2] = stair_score[1] + stair_score[2]
    for i in range(3, n + 1):
        dp[i] = max(dp[i - 3] + stair_score[i - 1] + stair_score[i], dp[i - 2] + stair_score[i])

    print(dp[n])
