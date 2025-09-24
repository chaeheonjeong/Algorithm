import heapq

que = []

n = int(input())
for _ in range(n):
    heapq.heappush(que, int(input()))

result = 0
while que:
    a = heapq.heappop(que)

    if not que:
        break
    b = heapq.heappop(que)

    sum = a + b
    result += sum
    heapq.heappush(que, sum)

print(result)