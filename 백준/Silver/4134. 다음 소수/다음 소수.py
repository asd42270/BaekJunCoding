import math
def isPrime(number):
    if number < 2:
        return False
    for i in range(2, int(math.sqrt(number))+1):
        if number%i==0:
            return False
    return True
n = int(input())
for _ in range(n):
    number = int(input())
    while True:
        if (isPrime(number)):
            print(number)
            break
        else:
            number+=1