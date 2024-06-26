import sys
from collections import Counter
n, m = map(int, sys.stdin.readline().split())
words = []
result = []
for _ in range(n):
    word = sys.stdin.readline().rstrip()
    if len(word) >= m:
        words.append(word)

words_count = Counter(words).most_common()
words_count.sort(key=lambda x: (-x[1], -len(x[0]), x[0]))

for word, count in words_count:
    print(word)