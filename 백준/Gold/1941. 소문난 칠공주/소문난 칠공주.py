from collections import deque
from itertools import combinations

board = [list(input()) for _ in range(5)]

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]

positions = []
for y in range(5):
    for x in range(5):
        positions.append((y, x))

answer = 0

def isGood(canBe):
    # canBe: ((0,1), (1,2), (2,3)...)

    visited = [[False] * 5 for _ in range(5)]

    que = deque()
    que.append((canBe[0][0], canBe[0][1]))
    visited[canBe[0][0]][canBe[0][1]] = True

    total_cnt = 0
    s_cnt = 0

    while que:
        total_cnt += 1
        now = que.popleft()
        if board[now[0]][now[1]] == 'S':
            s_cnt += 1

        for i in range(4):
            newY = now[0] + dirY[i]
            newX = now[1] + dirX[i]

            if newY < 0 or newY >= 5 or newX < 0 or newX >= 5:
                continue
            if visited[newY][newX]:
                continue
            if (newY, newX) in canBe:
                visited[newY][newX] = True
                que.append((newY, newX))

    if total_cnt == 7 and s_cnt >= 4:
        return True



for com in combinations(positions, 7):
    if isGood(com):
        answer += 1

print(answer)