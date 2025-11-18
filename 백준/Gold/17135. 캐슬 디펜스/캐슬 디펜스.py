from itertools import combinations

N,M,D = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

archer = []
for i in range(M):
    archer.append([N, i])

enemy = [[] for _ in range(N)]
for y in range(N):
    for x in range(M):
        if board[y][x] == 1:
            enemy[y].append([y,x])


def getAttackPos(y, x, start, board):
    minX = int(1e9)
    minY = int(1e9)
    minDiff = int(1e9)

    for i in range(start, -1, -1):
        for e in enemy[i]:
            if board[e[0]][e[1]] == 0:
                continue

            diff = abs(start+1-e[0]) + abs(x-e[1])
            if diff <= D:
                if diff < minDiff:
                    minY = e[0]
                    minX = e[1]
                    minDiff = diff
                elif diff == minDiff and e[1] < minX:
                    minY = e[0]
                    minX = e[1]
                    minDiff = diff

    return [minY, minX]


answer = 0
for pos in combinations(archer, 3):  # pos: ([3,0], [3,1], [3,2])
    start = N-1
    cnt = 0
    tempBoard = [x[:M] for x in board]

    while start >= 0:
        temp = set()
        for x in pos:   # x: [3,0]
            attY, attX = getAttackPos(x[0], x[1], start, tempBoard)
            if attY == int(1e9) or attX == int(1e9):
                continue
            temp.add((attY, attX))

        cnt += len(temp)
        for x in temp:
            tempBoard[x[0]][x[1]] = 0

        start -= 1

    answer = max(cnt, answer)

print(answer)