from collections import deque

N, L, R = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]
visited = [[0]*N for _ in range(N)]

dy = [-1, 0, +1, 0]
dx = [0, +1, 0, -1]
sum = 0
cnt = 0

def bfs(y, x, seq):
    global sum, cnt
    flag = True

    que = deque()
    que.append([y, x, board[y][x]])
    # visited[y][x] = seq
    
    while que:
        nowY, nowX, nowV = que.popleft()
        for i in range(4):
            newY = nowY + dy[i]
            newX = nowX + dx[i]

            if newY < 0 or newY >= N or newX < 0 or newX >= N:
                continue
            newV = board[newY][newX]
            if visited[newY][newX] > 0 or abs(nowV - newV) < L or abs(nowV - newV) > R:
                continue

            flag = False
            sum += newV
            cnt += 1
            visited[newY][newX] = seq
            que.append([newY, newX, newV])
    
    return flag


def move(target, seq):
    for y in range(N):
        for x in range(N):
            if visited[y][x] == seq:
                board[y][x] = target

answer = 0
while True:
    seq = 0
    visited = [[0] * N for _ in range(N)]
    flag = True

    for y in range(N):
        for x in range(N):
            if visited[y][x] > 0:
                continue

            sum = 0
            cnt = 0
            seq += 1
            if not bfs(y, x, seq):
                flag = False

            if not sum == 0 or not cnt == 0:
                move(sum // cnt, seq)

    if not flag:
        answer += 1
    else:
        break

print(answer)