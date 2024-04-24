n, m = map(int, input().split())
Encyclopedia = dict()

for i  in range(n):
    Encyclopedia[i]=input()

answers = dict()
word_dict = {value: key+1 for key, value in Encyclopedia.items()}
for i in range(m):
    question = input()
    if question.isdigit():
        answers[i]=Encyclopedia.get(int(question)-1)
    else:
        answers[i] = word_dict.get(question)
for value in answers.values():
    print(value)