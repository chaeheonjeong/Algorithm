from collections import deque

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]

def solution(maps):
    answer = 0
    N = len(maps)
    M = len(maps[0])
    visited = [[False] * M for _ in range(N)]
    
    que = deque()
    que.append((0,0))
    visited[0][0] = True
    
    while(que):
        now = que.popleft()
        
        for i in range(4):
            nY = now[0] + dirY[i]
            nX = now[1] + dirX[i]
            
            if nY < 0 or nY >= N or nX < 0 or nX >= M:
                continue
            if maps[nY][nX] == 0 or visited[nY][nX]:
                continue
            
            maps[nY][nX] = maps[now[0]][now[1]] + 1
            que.append((nY, nX))
            visited[nY][nX] = True
           
    answer = maps[N-1][M-1]
    if answer == 1: answer = -1
         
    
    return answer