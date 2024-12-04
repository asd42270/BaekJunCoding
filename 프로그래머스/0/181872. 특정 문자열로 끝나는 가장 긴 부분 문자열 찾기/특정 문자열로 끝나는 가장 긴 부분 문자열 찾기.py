def solution(myString, pat):
    
    return myString[:myString.rfind(pat[-1])+1]