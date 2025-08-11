n = int(input())

numbers = [1, 5, 10, 50]
answer = set()

def dfs(depth, total, start):
    if depth == n:
        answer.add(total)
        return;

    for i in range (start, 4):
        dfs(depth+1, total+numbers[i], i)


dfs(0, 0, 0)
print(len(answer))