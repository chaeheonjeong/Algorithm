def solution(s):
    answer = int(1e9)
    
    n = len(s)
    
    for k in range(1, n//2+1):
        prev = s[0:k]
        sum = 1
        temp = ''
        
        for i in range(k, n, k):
            cur = s[i:i+k]
            
            if prev == cur:
                sum = sum + 1
            else:
                if sum > 1:
                    temp = temp + str(sum)
                    sum = 1
                temp = temp + prev
                prev = cur
                
        if sum > 1:
            temp = temp + str(sum)
        temp = temp + cur
        
        
    
        answer = min(len(temp), answer)
        
    if answer == int(1e9): return len(s)
    return answer