from collections import deque

N = int(input())
board = [list(input()) for _ in range(N)]

ans = []

def printBoard():
    for y in range(N):
        for x in range(N):
            print(board[y][x] + ' ', end="")
        print()


def bfs(y, x):
    que = deque()
    que.append([y, x])
    board[y][x] = '0'
    cnt = 0

    dirY = [-1, 0, +1, 0]
    dirX = [0, +1, 0, -1]

    while que:
        nowY, nowX = que.popleft()
        cnt += 1

        for i in range(4):
            newY = nowY + dirY[i]
            newX = nowX + dirX[i]

            if newY < 0 or newY >= N or newX < 0 or newX >= N:
                continue
            if board[newY][newX] == '0':
                continue

            que.append([newY, newX])
            board[newY][newX] = '0'

    return cnt


for y in range(N):
    for x in range(N):
        if board[y][x] == '1':
            cnt = bfs(y, x)
            ans.append(cnt)

print(len(ans))
ans.sort()
for x in ans:
    print(x)