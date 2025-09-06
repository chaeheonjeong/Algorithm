def solution(word):
    arr = ['A', 'E', 'I', 'O', 'U']
    answer = 0
    cnt = 0
    found = False
    

    def dfs(s, depth):
        nonlocal cnt, answer, found
        
        if s == word:
            answer = cnt
            found = True
            return
        
        if depth == 5:
            return
        
        for i in range(5):
            if found:
                return
            
            cnt += 1
            dfs(s+arr[i], depth+1)
    
    dfs('', 0)
    
    return answer