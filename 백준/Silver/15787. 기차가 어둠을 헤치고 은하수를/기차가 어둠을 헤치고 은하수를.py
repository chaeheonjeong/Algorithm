N, M = map(int, input().split())

train = [[0]*20 for _ in range(N)]

for _ in range(M):
    arr = list(map(int, input().split()))

    if arr[0] == 1:
        r, i, x = arr
        train[i-1][x-1] = 1
    elif arr[0] == 2:
        r, i, x = arr
        train[i-1][x-1] = 0
    elif arr[0] == 3:
        r, i = arr
        train[i-1] = [0] + train[i-1][:-1]
    else:
        r, i = arr
        train[i-1] = train[i-1][1:] + [0]

result = set()
for i in range(N):
    result.add(tuple(train[i]))

print(len(result))