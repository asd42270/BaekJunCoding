nums=[]
count=1
for _ in range(10):
    num = int(input())
    nums.append(num%42)

nums.sort()
for i in range(len(nums)-1):
    if nums[i]!=nums[i+1]:
        count+=1
    else:
        continue
    if count <= 0:
        count=1
print(count)
    
    
