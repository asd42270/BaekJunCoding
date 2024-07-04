import sys

def min_rgb_score(rgb_score, n):

    dp = [[0] * 3 for _ in range(n)]

    #첫번째 집의 초기 비용
    dp[0][0] = rgb_score[0][0]
    dp[0][1] = rgb_score[0][1]
    dp[0][2] = rgb_score[0][2]

    for i in range(1, n):
        dp[i][0] = rgb_score[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = rgb_score[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = rgb_score[i][2] + min(dp[i-1][1], dp[i-1][0])

        # 마지막 집에서 최소 비용 선택
    return min(dp[n-1][0], dp[n-1][1], dp[n-1][2])

n = int(sys.stdin.readline().rstrip())

rgb_score =[]
for _ in range(n):
    rgb_score.append(list(map(int, sys.stdin.readline().split())))

print(min_rgb_score(rgb_score, n))