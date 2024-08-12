n, k = map(int, input().strip().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

dp = [0 for i in range(k + 1)]
dp[0] = 1

for coin in arr:
    for i in range(coin, k + 1):  # 현재 갖고 있는 동전 coin를 기준으로 coin 미만의 값은 갱신될리 없으므로 i부터 시작.
        dp[i] += dp[i - coin]

print(dp[k])