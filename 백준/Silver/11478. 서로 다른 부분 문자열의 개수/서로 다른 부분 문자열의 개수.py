s = input()
words = []
start, end = 0, 1
while start<len(s) and end <= len(s):
    word = s[start:end]
    words.append(word)
    end+=1
    if end>len(s):
        start+=1
        end=start+1
print(len(set(words)))