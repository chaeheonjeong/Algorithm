def solution(s):
    n = len(s)
    
    answer = n
    
    for k in range(1, n//2 + 1):
        prev = s[0:k]
        cnt = 1
        parts = []
        
        for i in range(k, n, k):
            cur = s[i:i+k]
            if cur == prev:
                cnt += 1
            else:
                if cnt > 1:
                    parts.append(str(cnt))
                parts.append(prev)
                prev = cur
                cnt = 1
                
        if cnt > 1:
            parts.append(str(cnt))
        parts.append(prev)
        
        compressed_len = len(''.join(parts))
        answer = min(answer, compressed_len)
        
    return answer