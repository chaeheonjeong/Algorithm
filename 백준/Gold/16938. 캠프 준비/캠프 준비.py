from itertools import combinations

N, L, R, X = map(int, input().split())
nums = list(map(int, input().split()))

nums.sort()
ans = 0

for i in range(2, N+1):
    for c in combinations(nums, i):
        temp = list(c)
        total = sum(temp)
        if temp[i-1] - temp[0] < X:
            continue
        if total < L or total > R:
            continue
        
        ans += 1

print(ans)