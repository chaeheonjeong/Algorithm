wheel = [input() for _ in range(4)]
K = int(input())
play = [list(map(int, input().split())) for _ in range(K)]


def rotate(idx, dir):
    lIdx = idx - 1
    rIdx = idx + 1

    if lIdx >= 0 and not visited[lIdx]:
        if int(wheel[idx][6]) + int(wheel[lIdx][2]) == 1:
            visited[lIdx] = True
            rotate(lIdx, dir * -1)
    if rIdx < 4 and not visited[rIdx]:
        if int(wheel[idx][2]) + int(wheel[rIdx][6]) == 1:
            visited[rIdx] = True
            rotate(rIdx, dir * -1)
    
    if dir == 1:
        wheel[idx] = wheel[idx][-1] + wheel[idx][:-1]
    else:
        wheel[idx] = wheel[idx][1:] + wheel[idx][0]


def getScore():
    score = 0
    for i in range(4):
        if int(wheel[i][0]) == 1:
            temp = 1
            for _ in range(i):
                temp *= 2
            score += temp

    return score


for i in range(K):
    idx, dir = play[i]
    visited = [False] * 4

    visited[idx-1] = True
    rotate(idx-1, dir)

print(getScore())