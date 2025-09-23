def solution(p):
    def splitS(s):
        start = 0
        end = 0
        result = []
        
        for i in range(len(s)):
            if s[i] == '(':
                start += 1
            else:
                end += 1
            
            if start == end:
                result.append(s[:i+1])
                result.append(s[i+1:])
                return result
            
        return result
        
        
    def isGood(s):
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append('(')
            else:
                if not stack:
                    return False
                stack.pop()
                
        if stack:
            return False
        else:
            return True
        
    
    def getU(s):
        s = s[1:len(s)-1]
        
        result = ''
        for i in range(len(s)):
            if s[i] == '(':
                result += ')'
            else:
                result += '('
                
        return result
    
    
    def circle(s):
        if len(s) == 0:
            return ''
        
        u, v = splitS(s)
        
        if isGood(u):
            temp = circle(v)
            return u + temp
        else:
            result = '('
            result += circle(v)
            result += ')'
            result += getU(u)
            return result
        
        return ''
    
    return circle(p) 