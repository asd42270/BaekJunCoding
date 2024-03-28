n = int(input())
movie_num=666
cnt=1
while True:
    if n==cnt:
        print(movie_num)
        break
    else:
        movie_num+=1
        if "666" in str(movie_num):
            cnt+=1