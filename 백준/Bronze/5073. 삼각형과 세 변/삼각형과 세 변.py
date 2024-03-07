result=[]
while True:
    triangle=list(map(int, input().split()))
    triangle.sort()
    if triangle[2]==0:
        break
    if triangle[2]>=triangle[0]+triangle[1]:
        result.append("Invalid")
    else:
        if triangle[0]==triangle[2]:
            result.append("Equilateral")
        elif triangle[0]==triangle[1] or triangle[1]==triangle[2]:
            result.append("Isosceles")
        else:
            result.append("Scalene")

for elem in result:
    print(elem)
