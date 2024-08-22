def solution(s):
    str_arr=[]
    
    for elem in s:
        str_arr.append(elem)
        
    return "".join(sorted(str_arr, reverse=True))