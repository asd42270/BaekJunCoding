import math

def isPrime(number):
    primes = [True]*1000000
    for i in range(2, int(math.sqrt(number))+1):
        if primes[i]:
            for j in range(i*i, number, i):
                primes[j] = False
    return primes

primes = isPrime(1000000)
prime = 2

testcase=int(input())
arr=[]

for _ in range(testcase):
    number = int(input())
    cnt=0
    for num in range(2, (number//2)+1):
        if (primes[num]):
            remainNum = number-num
            if (primes[remainNum]): 
                cnt+=1
    arr.append(cnt)

for elem in arr:
    print(elem)
