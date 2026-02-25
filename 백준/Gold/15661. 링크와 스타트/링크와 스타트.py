N = int(input())
abiliy = [list(map(int, input().split())) for _ in range(N)]
part = range(1,N+1)
answer = int(1e9)
stack = []


def updateAnswer():
    global answer

    tempA = 0
    for i in stack:
        for j in stack:
            tempA += abiliy[i-1][j-1]

    tempB = 0
    arr = []
    for i in range(1, N+1):
        if i not in stack:
            arr.append(i)

    for i in arr:
        for j in arr:
            tempB += abiliy[i-1][j-1]

    answer = min(answer, abs(tempA - tempB))


def dfs(now):
    if len(stack) == N:
        return
    if now >= N+1:
        updateAnswer();
        return

    stack.append(now)
    dfs(now+1)
    stack.pop()

    dfs(now+1)

stack.append(1)
dfs(2)

print(answer)