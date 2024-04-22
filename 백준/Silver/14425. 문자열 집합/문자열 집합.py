n, m = map(int, input().split())
words = set()
cnt=0
for _ in range(n):
    words.add(input())

for _ in range(m):
    word = input()
    if word in words:
        cnt+=1
    else:
        continue
print(cnt)