def solution(code):
    mode = 0
    ret = ""
    for i in range(len(code)):
        if mode == 0:
            if code[i] == "1":
                mode = 1
            else:
                if i%2==0:
                    ret+=code[i]
            
        else:
            if code[i] == "1":
                mode = 0
            else:
                if i%2!=0:
                    ret+=code[i]
                    
    return ret if ret else "EMPTY"