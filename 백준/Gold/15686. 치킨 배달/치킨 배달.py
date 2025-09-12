from itertools import combinations

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

chicken = []
for y in range(N):
    for x in range(N):
        if board[y][x] == 2:
            chicken.append([y,x])

def get_length(comb):
    total = 0
    for y in range(N):
        for x in range(N):
            if board[y][x] == 1:
                sum = int(1e9)
                for k in comb:
                    sum = min(abs(y - k[0]) + abs(x - k[1]), sum)

                total += sum

    return total




answer = int(1e9)
for i in range(1, M+1):
    for x in combinations(chicken, i):
        answer = min(get_length(x), answer)

print(answer)