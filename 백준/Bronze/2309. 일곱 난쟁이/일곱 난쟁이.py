from itertools import combinations

arr = []

for _ in range(9):
    height = int(input())
    arr.append(height)

all_combi = list(combinations(arr, 7))

for combi in all_combi:
    if sum(combi) == 100:
        for elem in sorted(list(combi)):
            print(elem)
        break