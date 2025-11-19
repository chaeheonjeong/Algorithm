A, B, C = map(int, input().split())

bottle = [A, B, C]
result = set()

def dfs(water):
    for i in range(3):
        for j in range(3):
            if i == j:
                continue
            tempWater = water[:]

            tempWater[i] += tempWater[j]
            tempWater[j] = 0
            if tempWater[i] > bottle[i]:
                tempWater[j] += tempWater[i] - bottle[i]
                tempWater[i] = bottle[i]

            if tuple(tempWater) not in result:
                result.add(tuple(tempWater))
                dfs(tempWater)

dfs([0, 0, C])

answer = []
for x in result:
    if x[0] == 0:
        answer.append(x[2])
    
answer.sort()
print(*answer)