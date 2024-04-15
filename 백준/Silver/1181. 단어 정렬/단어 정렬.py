n = int(input())
words= []

for i in range(n):
    word = input()
    if word not in words:
        words.append(word)
    else:
        continue
    

sorted_words = sorted(words, key= lambda x: (len(x),x))

for word in sorted_words:
    print(word)