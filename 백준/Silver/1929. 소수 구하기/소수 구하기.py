import math
def isPrime(number):
    if number < 2:
        return False
    for i in range(2, int(math.sqrt(number))+1):
        if number%i==0:
            return False
    return True
n, m = map(int, input().split())
for number in range(n, m+1):
    if (isPrime(number)):
        print(number)