def solution(arr, flag):
    x = []
    for i in range(len(flag)):
        if flag[i]:
            x+=([arr[i]] *(2*arr[i]))
        else:
            for _ in range(arr[i]):
                x.pop()
    return x