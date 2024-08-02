import sys

n = int(sys.stdin.readline().rstrip())
weights = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline().rstrip())
marbles = list(map(int, sys.stdin.readline().split()))

# 추의 무게와 구슬의 무게를 합했을 때 측정이 가능하면 Y, 아니면 N
# DP를 이용??
# 추만을 사용하여 구슬의 무게를 측정함. 구슬 하나에 추 여러 개고 구슬 여러 개 + 추 여러 개는 안된다.
# 구슬 + 추 or 구슬 = 나머지 추에서 뽑은 무게
# 1. 구슬의 무게와 같은 추가 있는 경우 - Y
# 2.  같은 추는 없지만 추 무게 조합으로 판단할 수 있는 경우
# ex) 구슬 하나씩 -> 구슬보다 작은 추만 선택 -> 더했을 때 값이 나오면 Y, 아니면 3번
# 3. 같은 추도 없고 추 무게만으로 조합이 안 돼서 구슬+추를 해야 하는 경우
# ex) 구슬 1g, 같은 추 없음 -> 가장 작은 것부터 더한다. -> 나머지 추를 더해서 구할 수 있는지?(구간 합)-DP
# 가능하다면 Y, 안 되면 그 다음 작은 수 더한다. -> (구간 합) - DP
# 아니면 구슬 + 추의 무게에서 남은 추에서 하나를 빼고 뺀 값이 남은 거에 있으면 Y, 없으면 다음 거 더하고 반복
# 이 마저도 안 되면 N

# 가능한 무게를 저장할 집합
possible_weights = set()
possible_weights.add(0)

# 동적 프로그래밍으로 가능한 무게 계산
for weight in weights:
    new_weights = set()
    for pw in possible_weights:
        new_weights.add(pw + weight)
        new_weights.add(abs(pw - weight))
    possible_weights.update(new_weights)

# 결과 출력
results = []
for marble in marbles:
    if marble in possible_weights:
        results.append("Y")
    else:
        results.append("N")

print(" ".join(results))