X, N = map(int, input().split())
visitor = list(map(int, input().split()))

total = 0

for i in range(N):
    total += visitor[i]

max = total
cnt = 1

for i in range(N, X):
    total -= visitor[i-N]
    total += visitor[i]

    if max == total:
        cnt += 1
    elif total > max:
        cnt = 1
        max = total

if max == 0:
    print('SAD')
else:
    print(max)
    print(cnt)