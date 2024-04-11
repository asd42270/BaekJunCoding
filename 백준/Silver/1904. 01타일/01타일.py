n = int(input())
if n <= 2:
    print(n)
else:
    a, b = 1, 2
    for i in range(3, n + 1):
        a, b = b, (a + b) % 15746
    print(b)
