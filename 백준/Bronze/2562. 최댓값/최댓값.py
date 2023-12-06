nums=[]
for i in range(9):
    num = int(input())
    nums.append(num)

a = max(nums)
print(a)
print(nums.index(a)+1)