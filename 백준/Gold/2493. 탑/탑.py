N = int(input())
arr = list(map(int, input().split()))

ans = [0 for _ in range(N)]

stack = []
for i in range(N):
    while stack and arr[i] > stack[-1][0]:
        t = stack.pop()
        if stack:
            ans[t[1]] = stack[-1][1] + 1
    
    stack.append([arr[i], i])

while stack:
    t = stack.pop()

    if not stack:
        break
    ans[t[1]] = stack[-1][1] + 1

for x in ans:
    print(x, end=" ")
print()