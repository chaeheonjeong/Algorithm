import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

dp = [[0, 0] for _ in range(N+1)]
visited = [False] * (N+1)

def dfs(node):
    visited[node] = True
    dp[node][1] = 1

    for neighbor in tree[node]:
        if not visited[neighbor]:
            dfs(neighbor)
            dp[node][0] += dp[neighbor][1]
            dp[node][1] += min(dp[neighbor][0], dp[neighbor][1])

dfs(1)

print(min(dp[1][0], dp[1][1]))
