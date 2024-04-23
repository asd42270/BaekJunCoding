n = int(input())
attends = dict()
for _ in range(n):
    name, state = map(str, input().split())
    if state=="enter":
        attends[name]=state
    else:
        attends.pop(name)

sorted_attends = sorted(attends, reverse=True)
for name in sorted_attends:
    print(name)