n = int(input())
scores = list(map(int, input().split()))
scores.sort()    
sum=0
for i in range(len(scores)):
    sum+=scores[i]/scores[-1]*100

avg = sum/len(scores)

print(avg)