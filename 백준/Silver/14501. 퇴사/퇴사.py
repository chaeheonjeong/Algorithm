N = int(input())
time = []
price = []

for _ in range(N):
    t, p = map(int, input().split())
    time.append(t)
    price.append(p)

dp = [0] * (N+1)

for i in range(0, N):
    dp[i] = max(dp[i], dp[i-1] if i > 0 else 0)

    if i + time[i] <= N:
        dp[i + time[i]] = max(dp[i] + price[i], dp[i+time[i]])

print(max(dp[N], dp[N-1]))