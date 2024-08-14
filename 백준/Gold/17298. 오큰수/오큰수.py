import sys

def NGE(n, arr):
    stack = []
    result = [-1] * n  # 결과 배열을 -1로 초기화

    for i in range(n):
        # 스택이 비어있지 않고, 현재 arr[i]가 스택의 top에 있는 인덱스에 해당하는 값보다 크다면
        while stack and arr[stack[-1]] < arr[i]:
            result[stack.pop()] = arr[i]
        
        # 현재 인덱스를 스택에 추가
        stack.append(i)
    
    return result

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().split()))

result = NGE(n, arr)

for elem in result:
    print(elem, end=" ")
