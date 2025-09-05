from collections import deque

def solution(s):
    answer = 0
    
    que = deque(list(s))
    
    
    def isAnswer(arr):
        stack = []
        
        for x in arr:
            if x == '[' or x == '{' or x == '(':
                stack.append(x)
            else:
                if not stack:
                    return False
                t = stack.pop()
                
                if x == ']' and t != '[':
                    return False
                elif x == '}' and t != '{':
                    return False
                elif x == ')' and t != '(':
                    return False
            
        return not stack

    
    for _ in range(len(s)):
        if isAnswer(que):
            answer = answer + 1
            
        now = que.popleft()
        que.append(now)
        
    
    return answer