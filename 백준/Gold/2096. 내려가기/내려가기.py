N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

prev = [board[0][0], board[0][1], board[0][2]]
new = [0] * 3

def switch():
    for i in range(3):
        prev[i] = new[i]

for y in range(N-1):
    for x in range(3):
        if x == 0:
            new[0] = prev[0] + board[y+1][x]
            new[1] = prev[0] + board[y+1][x+1]
        elif x == 1:
            new[0] = min(new[0], prev[1] + board[y+1][x-1])
            new[1] = min(new[1], prev[1] + board[y+1][x])
            new[2] = prev[1] + board[y+1][x+1]
        else:
            new[1] = min(new[1], prev[2] + board[y+1][x-1])
            new[2] = min(new[2], prev[2] + board[y+1][x])
    switch()

minAns = min(min(prev[0], prev[1]), prev[2])


prev = [board[0][0], board[0][1], board[0][2]]
for y in range(N-1):
    for x in range(3):
        if x == 0:
            new[0] = prev[0] + board[y+1][x]
            new[1] = prev[0] + board[y+1][x+1]
        elif x == 1:
            new[0] = max(new[0], prev[1] + board[y+1][x-1])
            new[1] = max(new[1], prev[1] + board[y+1][x])
            new[2] = prev[1] + board[y+1][x+1]
        else:
            new[1] = max(new[1], prev[2] + board[y+1][x-1])
            new[2] = max(new[2], prev[2] + board[y+1][x])
    switch()

maxAns = max(max(prev[0], prev[1]), prev[2])


print(maxAns, minAns)