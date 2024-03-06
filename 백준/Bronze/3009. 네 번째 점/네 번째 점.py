x=[]
y=[]
for i in range(3):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)
x.sort()
y.sort()
if x.count(x[0])==1:
    w=x[0]
else:
    w=x[2]
if y.count(y[0])==1:
    h=y[0]
else:
    h=y[2]
print(w, h)