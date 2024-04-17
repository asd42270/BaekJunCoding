n = int(input())
dots= list(map(int, input().split()))
sorted_dots = list(set(dots))
sorted_dots.sort()
index_dict = {value: index for index, value in enumerate(sorted_dots)}

dots = [index_dict[dot] for dot in dots]

for dot in dots:
    print(dot, end=' ')