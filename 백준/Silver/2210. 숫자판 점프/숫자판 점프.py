board = [input().split() for _ in range(5)]
    
dirY = [-1, 0, +1, 0]
dirX = [0, +1, 0, -1]
ans = set()

def dfs(y, x, depth, s):
    global ans
    if depth == 6:
        ans.add(s)
        return

    for i in range(4):
        newY = y + dirY[i]
        newX = x + dirX[i]

        if newY < 0 or newY >= 5 or newX < 0 or newX >= 5:
            continue

        dfs(newY, newX, depth+1, s+board[newY][newX])

for y in range(5):
    for x in range(5):
        dfs(y, x, 1, board[y][x])


print(len(ans))