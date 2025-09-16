def solution(n, wires):
    graph = [[] for _ in range(n)]
    visited = [False] * n
    answer = int(1e9)
    
    for x in wires:
        graph[x[0]-1].append(x[1]-1)
        graph[x[1]-1].append(x[0]-1)
        
    def dfs(now):
        nonlocal answer
        
        sum = 1
        for x in graph[now]:
            if not visited[x]:
                visited[x] = True
                sum += dfs(x)
           

        answer = min(abs(sum - (n-sum)), answer)
        return sum

        
    for i in range(n):
        if not visited[i]:
            dfs(i)
            
    return answer
    
    