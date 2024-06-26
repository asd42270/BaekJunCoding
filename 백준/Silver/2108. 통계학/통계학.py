import sys
from collections import Counter

# 입력 읽기
n = int(sys.stdin.readline().rstrip())
number = []
sum = 0
for _ in range(n):
    num = int(sys.stdin.readline().rstrip())
    sum += num
    number.append(num)

# 리스트 정렬
number.sort()

# Counter를 이용한 빈도수 계산
cnt = Counter(number)

# 산술평균 계산 및 결과에 추가
result = [round(sum / n)]

# 중앙값 계산 및 결과에 추가
result.append(number[n // 2])

# 최빈값 계산
most_common_list = cnt.most_common()
most_common_list.sort(key=lambda x: (-x[1], x[0]))

if len(most_common_list) > 1 and most_common_list[0][1] == most_common_list[1][1]:
    result.append(most_common_list[1][0])
else:
    result.append(most_common_list[0][0])

# 범위 계산 (절대값 고려)
mi, ma = min(number), max(number)
result.append(ma - mi)

# 결과 출력
for elem in result:
    print(elem)
