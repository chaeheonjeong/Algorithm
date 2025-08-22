from itertools import permutations

n = int(input())
arr = list(map(int, input().split()))
visited = [False] * n

def dfs(temp, depth):
    if depth >= 2:
        a = temp[depth-2]
        b = temp[depth-1]

        if b != a * 2 and not (a % 3 == 0 and b == a // 3):
            return

    if depth == n:
        print(" ".join(map(str,temp)))
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            temp.append(arr[i])
            dfs(temp, depth+1)
            visited[i] = False
            temp.pop()

dfs([], 0)