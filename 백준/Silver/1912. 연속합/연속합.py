import sys

def max_subarray_sum(nums):
    max_sum = -sys.maxsize
    current_sum = 0
    
    for num in nums:
        current_sum = max(num, current_sum + num)
        max_sum = max(max_sum, current_sum)
    
    return max_sum

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().split()))

print(max_subarray_sum(nums))
