from collections import deque

N, W, L = map(int, input().split())
trucks = list(map(int, input().split()))

time = 1
que = deque()

que.append([trucks[0], 1])
sum = trucks[0]
p = 1

while que:
    time += 1
    size = len(que)

    for _ in range(size):
        truck, go = que.popleft()
        if go < W:
            que.append([truck, go+1])
        else:
            sum -= truck

    if p < N:
        if sum + trucks[p] <= L:
            que.append([trucks[p], 1])
            sum += trucks[p]
            p += 1

print(time)