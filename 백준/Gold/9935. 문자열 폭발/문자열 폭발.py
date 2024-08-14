import sys

words = sys.stdin.readline().rstrip()
bomb = list(sys.stdin.readline().rstrip())
stack = []

for i in range(len(words)):
    stack.append(words[i])
    if stack[-len(bomb):] == bomb:
        del stack[-len(bomb):]

if len(stack)>0:
    for word in stack:
        print(word, end="")
else:
    print("FRULA")