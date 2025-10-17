from itertools import combinations
from collections import deque
import copy

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

virus = []
empty = []
for y in range(N):
    for x in range(M):
        if board[y][x] == 2:
            virus.append([y,x])
        elif board[y][x] == 0:
            empty.append([y, x])

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]
def bfs(temp):
    que = deque()
    for x in virus:
        que.append(x)

    while que:
        nowY, nowX = que.pop()
        for i in range(4):
            newY = nowY + dirY[i]
            newX = nowX + dirX[i]

            if newY < 0 or newY >= N or newX < 0 or newX >= M:
                continue
            if not temp[newY][newX] == 0:
                continue
            
            temp[newY][newX] = 2
            que.append([newY, newX])

def getCount(temp):
    cnt = 0
    for y in range(N):
        for x in range(M):
             if temp[y][x] == 0:
                 cnt += 1

    return cnt

answer = 0
for x in combinations(empty, 3):
    for pos in x:
        board[pos[0]][pos[1]] = 1

    temp = [row[:] for row in board]
    bfs(temp)

    cnt = getCount(temp)
    answer = max(answer, cnt)

    for pos in x:
        board[pos[0]][pos[1]] = 0

print(answer)