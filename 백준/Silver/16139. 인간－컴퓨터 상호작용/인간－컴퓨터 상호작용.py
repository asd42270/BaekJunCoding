import sys

string = sys.stdin.readline().rstrip()

n = int(sys.stdin.readline().rstrip())
result=[]

# 문자의 위치를 저장할 리스트를 초기화합니다.
index = {}

# 문자열을 한 번 순회하여 각 문자들의 위치를 저장합니다.
for i in range(len(string)):
    if string[i] not in index:
        index[string[i]] = []
    index[string[i]].append(i)


for _ in range(n):
    a, l, r = map(str,sys.stdin.readline().split())
    cnt = 0

    # 문자가 문자열에 존재하는 경우에만 처리합니다.
    if a in index:
        for i in index[a]:
            if int(l) <= i and i <= int(r):
                cnt += 1

    result.append(cnt)

for elem in result:
    print(elem)