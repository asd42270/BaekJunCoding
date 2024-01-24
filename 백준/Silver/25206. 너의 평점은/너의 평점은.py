grade={"A+" : 4.5, "A0" : 4.0, "B+" : 3.5, 
       "B0" : 3.0, "C+" : 2.5, "C0" : 2.0, 
       "D+" : 1.5, "D0" : 1.0, "F" : 0.0}
totalgrade, totalclass=0, 0
for _ in range(20):
    course = list(map(str,input().split()))
    if course[2]=="P":
        continue
    else:
        totalgrade +=(float(course[1])*grade[course[2]])
        totalclass+=(float(course[1]))
print(totalgrade/(totalclass))