n, m = map(int, input().split())
nums = [i for i in range(1,n+1)]
for _ in range(m):
    i, j = map(int, input().split())
    subNum =nums[i-1:j]
    subNum.reverse()
    count=0
    for h in range(i-1, j):
        nums[h] = subNum[count]
        count+=1

for num in nums:
    print(num, end=' ')
