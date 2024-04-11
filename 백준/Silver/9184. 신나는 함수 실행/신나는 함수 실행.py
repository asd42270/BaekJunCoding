memo = [[[1] * (21) for _ in range(21)] for _ in range(21)]
 # 각 차원의 요소들을 개별적으로 생성
for a in range(21):
    for b in range(21):
        for c in range(21):           
            if a<=0 or b<=0 or c<=0:
                memo[a][b][c]= 1
            elif a < b and b < c:
                memo[a][b][c]= memo[a][b][c-1]+memo[a][b-1][c-1] - memo[a][b-1][c]
            else:
                memo[a][b][c]= memo[a-1][b][c] + memo[a-1][b-1][c]+memo[a-1][b][c-1] - memo[a-1][b-1][c-1]
  
answ=[]
while True:
    a, b, c = map(int, input().split())
    if a== -1 and b==-1 and c==-1:
      break
    if a<=0 or b<=0 or c<=0:
        str = f"w({a}, {b}, {c}) = 1"
    elif a > 20 or b >20 or c >20:
        str = f"w({a}, {b}, {c}) = {memo[20][20][20]}"
    else:
        str = f"w({a}, {b}, {c}) = {memo[a][b][c]}"
    answ.append(str)

for answer in answ:
    print(answer)