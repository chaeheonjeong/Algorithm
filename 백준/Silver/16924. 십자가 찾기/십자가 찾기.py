n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

visited = [[False for _ in range(m)] for _ in range(n)]

dirY = [-1, 0, 1, 0]
dirX = [0, +1, 0, -1]

answer = []

for y in range(n):
    for x in range(m):
        if board[y][x] == '.':
            continue
        
        num = 1
        while(True):
            for i in range(4):
                newY = y + num * dirY[i]
                newX = x + num * dirX[i]

                if newY < 0 or newY >= n or newX < 0 or newX >= m:
                    break
                if board[newY][newX] == '.':
                    break

            else: # for문이 정상적으로 통과
                for i in range(4):
                    newY = y + num * dirY[i]
                    newX = x + num * dirX[i]
                    visited[newY][newX] = True
                visited[y][x] = True

                answer.append([y+1, x+1, num])
                num += 1
                continue

            break

for y in range(n):
    for x in range(m):
        if board[y][x] == '*' and not visited[y][x]:
            print(-1)
            exit()

print(len(answer))
for row in answer:
    print(*row)