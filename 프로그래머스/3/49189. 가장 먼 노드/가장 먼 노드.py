from collections import deque

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    visited = [False] * (n+1)
    
    for x in edge:
        graph[x[0]].append(x[1])
        graph[x[1]].append(x[0])
        
        
    value = 0
    answer = 0
    
    que = deque()
    que.append([1, 1])
    visited[1] = True
    
    while que:
        now, depth = que.popleft()
        if depth > value:
            answer = 1
            value = depth
        elif depth == value:
            answer += 1
        
        for x in graph[now]:
            if visited[x]:
                continue
            
            visited[x] = True
            que.append([x, depth+1])
            
    return answer