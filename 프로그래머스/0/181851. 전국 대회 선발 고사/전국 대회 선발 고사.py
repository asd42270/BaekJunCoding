def solution(rank, attendance):
    attenders = dict()
    for r, a in zip(rank, attendance):
        if a:
            attenders[r] = rank.index(r)
    
    sort_dict = sorted(attenders.items())
    answer = 10000 * sort_dict[0][1] + 100 * sort_dict[1][1] + sort_dict[2][1] 
        
    
    return  answer