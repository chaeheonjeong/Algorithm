from collections import deque

N = int(input())
board = [[0] * N for _ in range(N)]

def printArr():
    for y in range(N):
        for x in range(N):
            print(board[y][x], end="")
        print()
    print('================================')

K = int(input())
for _ in range(K):
    y, x = input().split()
    board[int(y)-1][int(x)-1] = 2

time = []
L = int(input())
for _ in range(L):
    time.append(input().split())

snake = deque()
snake.append([0, 0])
board[0][0] = 1

timeIdx = 0
t = 0

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]
dir = 1

while True:
    startY, startX = snake[0]
    newY = startY + dirY[dir]
    newX = startX + dirX[dir]

    if newY < 0 or newY >= N or newX < 0 or newX >= N:
        print(t+1)
        break
    if board[newY][newX] == 1:
        print(t+1)
        break
    if not board[newY][newX] == 2:
        endY, endX = snake.pop()
        board[endY][endX] = 0

    snake.appendleft([newY, newX])
    board[newY][newX] = 1
    t += 1

    if timeIdx < L and t == int(time[timeIdx][0]):
        if time[timeIdx][1] == 'D':
            dir = (dir + 1) % 4
        elif time[timeIdx][1] == 'L':
            dir = (dir + 3) % 4
        timeIdx += 1