import heapq
import sys

input = sys.stdin.readline

N = int(input())
time = [list(map(int, input().split())) for _ in range(N)]
time.sort(key=lambda x: (x[0], x[1]))

result = [time[0][1]]
for x in time[1:]:
    if x[0] < result[0]:
        heapq.heappush(result, x[1])
    else:
        heapq.heappop(result)
        heapq.heappush(result, x[1])

print(len(result))