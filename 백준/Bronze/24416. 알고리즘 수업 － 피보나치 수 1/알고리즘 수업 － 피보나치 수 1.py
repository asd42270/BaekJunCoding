n = int(input())
def fib(n):
    a, b = 1, 1 # f(1), f(2)
    for i in range(3, n+1): # 1, 2는 이미 정의했으므로 3부터 n까지
        a, b = b, a+b

    return b
print(fib(n), n-2)