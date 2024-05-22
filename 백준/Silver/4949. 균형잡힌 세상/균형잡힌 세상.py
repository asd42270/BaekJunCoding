from collections import deque
import re

result = []
while True:
    text = input()
    stack = deque()
    if text == ".":
        break
    filteredText = re.findall("[()\\[\\]]", text)
    balanced = True
    for ft in filteredText:
        if ft == "(" or ft == "[":
            stack.append(ft)
        else:
            if not stack:
                balanced = False
                break
            else:
                top = stack.pop()
                if (ft == ")" and top != "(") or (ft == "]" and top != "["):
                    balanced = False
                    break
    if balanced and not stack:
        result.append("yes")
    else:
        result.append("no")

for elem in result:
    print(elem)
