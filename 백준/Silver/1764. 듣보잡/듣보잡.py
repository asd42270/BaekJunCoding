n, m = map(int, input().split())
listen = set()
for _ in range(n):
    listen.add(input())

seen = set()
for _ in range(m):
    seen.add(input())

listen_and_seen = sorted(listen.intersection(seen))

print(len(listen_and_seen))
for elem in listen_and_seen:
    print(elem)