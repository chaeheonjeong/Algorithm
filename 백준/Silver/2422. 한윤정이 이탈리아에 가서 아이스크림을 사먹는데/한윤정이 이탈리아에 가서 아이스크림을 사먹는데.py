from itertools import combinations

n, m = map(int, input().split())

ice = list(combinations(range(1, n+1), 3))
arr = [[False] * (n+1) for _ in range(n+1)]

for i in range(m):
    x, y = map(int, input().split())
    arr[x][y] = True
    arr[y][x] = True

count = 0

for i in ice:
    if arr[i[0]][i[1]] or arr[i[0]][i[2]] or arr[i[1]][i[2]]:
        continue

    count += 1

print(count)