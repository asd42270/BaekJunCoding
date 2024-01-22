from collections import Counter

str_input = input().upper()

# 문자 빈도수 계산
char_count = Counter(str_input)

# 가장 많이 나온 문자 찾기
max_count = max(char_count.values())
most_common_chars = [char for char, count in char_count.items() if count == max_count]

if len(most_common_chars) == 1:
    print(most_common_chars[0])
else:
    print("?")
