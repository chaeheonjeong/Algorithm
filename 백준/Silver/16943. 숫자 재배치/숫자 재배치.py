s = input().split(' ')
arr = list(s[0])
limit = int(s[1])

visited = [False] * len(arr)
answer = -1

def dfs(str, depth):
    global answer
    if depth == len(arr):
        temp = int(str)
        if answer < temp and temp < limit:
            answer = temp

    for i in range(len(arr)):
        if not visited[i]:
            visited[i] = True
            dfs(str + arr[i], depth+1)
            visited[i] = False
    

for i in range(len(arr)):
    if arr[i] == '0':
        continue

    visited[i] = True
    dfs(arr[i], 1)
    visited[i] = False

print(answer)