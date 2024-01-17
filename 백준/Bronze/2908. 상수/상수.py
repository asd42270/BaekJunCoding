a, b = map(str, input().split())
a, b = a[::-1], b[::-1]
if a < b:
    print(b)
else:
    print(a)
