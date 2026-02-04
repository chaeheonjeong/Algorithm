from collections import deque

y, x = map(int, input().split())
board = [list(input()) for _ in range(y)]

dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]

coins = []
for i in range(y):
    for j in range(x):
        if board[i][j] == 'o':
            coins.append([i, j])


def bfs():
    que = deque([coins])

    while que:
        c1, c2, cnt = que.popleft()
        if cnt[0] == 10:
            return -1

        for i in range(4):
            n_c1 = [c1[0] + dirY[i], c1[1] + dirX[i]]
            n_c2 = [c2[0] + dirY[i], c2[1] + dirX[i]]

            if (n_c1[0] < 0 or n_c1[0] >= y or n_c1[1] < 0 or n_c1[1] >= x) and (n_c2[0] >= 0 and n_c2[0] < y and n_c2[1] >= 0 and n_c2[1] < x):
               return cnt[0]+1
            if (n_c2[0] < 0 or n_c2[0] >= y or n_c2[1] < 0 or n_c2[1] >= x) and (n_c1[0] >= 0 and n_c1[0] < y and n_c1[1] >= 0 and n_c1[1] < x):
               return cnt[0]+1
            if n_c1[0] < 0 or n_c1[0] >= y or n_c1[1] < 0 or n_c1[1] >= x or n_c2[0] < 0 or n_c2[0] >= y or n_c2[1] < 0 or n_c2[1] >= x:
               continue
            if board[n_c1[0]][n_c1[1]] == '#':
                n_c1 = c1
            if board[n_c2[0]][n_c2[1]] == '#':
                n_c2 = c2

            
            que.append([n_c1, n_c2, [cnt[0]+1]])

    return -1

               

coins.append([0])
print(bfs())