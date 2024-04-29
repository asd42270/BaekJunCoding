from bisect import bisect_left, bisect_right
from collections import Counter

def count_by_range(array, left, right):
    right_index = bisect_right(array, right)
    left_index = bisect_left(array, left)
    return right_index - left_index

n = int(input())
numbers = list(map(int, input().split()))
# Counter를 사용하여 각 숫자의 개수를 미리 계산
count = Counter(numbers)

m = int(input())
ans_numbers = list(map(int, input().split()))
for i in range(m):
    # ans_numbers의 각 요소가 count 딕셔너리에 있는지 확인하고, 있으면 해당 값을 가져옴
    ans_numbers[i] = count.get(ans_numbers[i], 0)

for elem in ans_numbers:
    print(elem, end=' ')
