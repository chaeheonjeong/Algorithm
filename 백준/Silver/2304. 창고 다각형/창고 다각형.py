N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

board.sort(key=lambda x: x[0])

maxIdx = 0
for i in range(N):
    if board[i][1] > board[maxIdx][1]:
        maxIdx = i

stack = []
for i in range(maxIdx, -1,-1):
    stack.append(board[i])

init = stack.pop()
sum = 0
mH = init[1]; mI = init[0]
while stack:
    now = stack.pop()
    if now[1] >= mH:
        sum += (now[0] - mI) * mH
        mH = now[1]
        mI = now[0]


for i in range(maxIdx, N):
    stack.append(board[i])

init = stack.pop()
mH = init[1]; mI = init[0]
while stack:
    now = stack.pop()
    if now[1] >= mH:
        sum += abs(now[0] - mI) * mH
        mH = now[1]
        mI = now[0]

sum += board[maxIdx][1]
print(sum)