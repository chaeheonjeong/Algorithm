def solution(genres, plays):
    N = len(genres)
    gen_dict = {}
    answer = []
    
    def add_answer(list):
        nonlocal answer
        list.sort(key=lambda x:(-x[0], x[1]))
        answer.append(list[0][1])
        
        if len(list)>1:
            answer.append(list[1][1])
    
    for i in range(N):
        gen_dict[genres[i]] = gen_dict.get(genres[i], 0) + plays[i]
        
    sorted_items = sorted(gen_dict.items(), key=lambda x : x[1], reverse=True)
    
    for x in sorted_items:
        temp = []
        for i in range(N):
            if x[0] == genres[i]:
                temp.append([plays[i], i])
        
        add_answer(temp)
        
    return answer