import sys
input = sys.stdin.read
data = input().split()

S = data[0]
q = int(data[1])

# 알파벳별 누적 합 배열을 딕셔너리로 생성
prefix_sum = {chr(c): [0] * (len(S) + 1) for c in range(ord('a'), ord('z') + 1)}

# 누적 합 배열을 채우기
for i in range(len(S)):
    char = S[i]
    for c in prefix_sum:
        prefix_sum[c][i + 1] = prefix_sum[c][i] + (1 if char == c else 0)

# 질문을 처리하기
results = []
index = 2
for _ in range(q):
    a = data[index]
    l = int(data[index + 1])
    r = int(data[index + 2])
    index += 3
    
    if l == 0:
        result = prefix_sum[a][r + 1]
    else:
        result = prefix_sum[a][r + 1] - prefix_sum[a][l]
    
    results.append(result)

# 결과 출력
sys.stdout.write('\n'.join(map(str, results)) + '\n')
