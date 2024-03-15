def solution(s):
    answer = True
    stack=[]
    for i in range(len(s)):
        if s[i]=='(':
            stack.append(s[i])
        else:
            if len(stack)>0:
                stack.pop()
            else:
                return False
    if len(stack)==0:
        return answer
    else:
        return False
