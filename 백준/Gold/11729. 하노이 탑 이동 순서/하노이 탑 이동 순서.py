def hanoi(n, start, end):
    if n==1:
        print(start, end) 
    else:
        #n-1개를 1에서 2로 옮기기
        hanoi(n-1, start, 6-start-end)
        #마지막을 1에서 3으로
        hanoi(1, start, end)
        #n-1을 2에서 3으로
        hanoi(n-1, 6-start-end, end)

n = int(input())
print(2**n-1)
hanoi(n, 1, 3)