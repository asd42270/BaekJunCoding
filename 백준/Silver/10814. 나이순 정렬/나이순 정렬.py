n = int(input())
members= []

for i in range(n):
    (age, name) = map(str, input().split())
    members.append((age, name))
    

members.sort(key= lambda x: (int(x[0])))

for member in members:
    for member_info in member:
        print(member_info, end=' ')
    print()