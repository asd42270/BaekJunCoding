import sys

def cantor_set(lines, left, right):
    if right - left < 2:
        return lines
    
    third = (right - left + 1) // 3
    left_mid = left + third
    right_mid = left + 2 * third

    # 현재 구간의 중앙 부분을 공백으로 변경
    lines = lines[:left_mid] + ' ' * (right_mid - left_mid) + lines[right_mid:]

    # 재귀적으로 왼쪽 부분과 오른쪽 부분에 대해 Cantor set 계산
    lines = cantor_set(lines, left, left_mid - 1)
    lines = cantor_set(lines, right_mid, right)
    
    return lines

# 입력 처리
n = int(sys.stdin.readline().rstrip())
result =[]
while n is not None:
    try:
        lines = "-" * (3**n)
        # Cantor set 생성 및 출력
        result.append(cantor_set(lines, 0, len(lines) - 1))
        n = int(sys.stdin.readline().rstrip())
    except:
        break
    
for elem in result:
    print(elem)