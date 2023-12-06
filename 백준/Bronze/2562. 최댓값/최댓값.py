nums=[]
for i in range(9):
    num = int(input())
    nums.append(num)
max=-1
index = 0
for i in range(len(nums)):
    if nums[i] > max:
        max = nums[i]
        index = i
print(max)
print(index+1)