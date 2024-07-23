import sys

def divide(a, b, c):
    if b==0:
        return 1
    elif b==1:
        return a%c
    else:
        p = divide(a, b//2, c)
        if b%2 == 1:
            return (p * p * a)%c
        else:
            return (p *p)%c


a, b, c = map(int, sys.stdin.readline().split())

print(divide(a, b, c))