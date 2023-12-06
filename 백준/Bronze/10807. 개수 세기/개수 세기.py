n = int(input())
nums = list(map(int, input().split()))
v = int(input())
count=0
for num in nums:
    if num== v:
        count+=1
print(count)