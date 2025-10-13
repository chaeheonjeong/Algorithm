from itertools import combinations

N = int(input())
board = [input().split() for _ in range(N)]

avail = []
teach = []
answer = False

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]
def isAnswer():
    for t in teach:
        for i in range(4):
            weight = 1
            while True:
                newY = t[0] + dirY[i] * weight
                newX = t[1] + dirX[i] * weight

                if newY < 0 or newY >= N or newX < 0 or newX >= N:
                    break
                if board[newY][newX] == 'O':
                    break
                if board[newY][newX] == 'S':
                    return False
                
                weight += 1
        
    return True


for y in range(N):
    for x in range(N):
        if board[y][x] == 'T':
            teach.append([y,x])
        elif board[y][x] == 'X':
            avail.append([y,x])

for x in combinations(avail, 3):
    for pos in x:
        board[pos[0]][pos[1]] = 'O'

    if isAnswer():
        answer = True
        break

    for pos in x:
        board[pos[0]][pos[1]] = 'X'

if answer:
    print('YES')
else:
    print('NO')