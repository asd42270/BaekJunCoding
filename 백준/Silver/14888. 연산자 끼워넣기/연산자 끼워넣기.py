import sys

def cal(nums, conductors, result, idx=1):
    if sum(conductors) == 0:
        results.append(result)
    else:
        for i in range(4):
            if conductors[i] > 0:
                conductors[i]-=1
                if i == 0:
                    cal(nums, conductors, result + nums[idx], idx + 1)
                elif i == 1:
                    cal(nums, conductors, result - nums[idx], idx + 1)
                elif i == 2:
                    cal(nums, conductors, result * nums[idx], idx + 1)
                elif i == 3:
                    if result < 0:
                        cal(nums, conductors, -(-result // nums[idx]), idx+1)
                    else:
                        cal(nums, conductors, result // nums[idx], idx + 1)
                conductors[i]+=1

n = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().split()))
conductors = list(map(int, sys.stdin.readline().split()))
results = []
first_val = nums[0]
results = []
cal(nums, conductors, first_val)
print(max(results))
print(min(results))
