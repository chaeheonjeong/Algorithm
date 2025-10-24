N, K = map(int, input().split())
belt = list(map(int, input().split()))
robot = [False] * N
answer = 0

def check():
    cnt = 0
    for x in belt:
        if x == 0:
            cnt += 1
    
    if cnt >= K:
        return False
        
    return True

def move():
    for i in range(N-1, 0, -1):
        if robot[i-1] and belt[i] > 0 and not robot[i]:
            robot[i] = True
            robot[i-1] = False
            belt[i] -= 1
    robot[-1] = False


while True:
    answer += 1
    
    belt = [belt[-1]] + belt[:-1]
    robot = [robot[-1]] + robot[:-1]
    robot[-1] = False

    move()

    if belt[0] > 0 and not robot[0]:
        belt[0] -= 1
        robot[0] = True

    if belt.count(0) >= K:
        print(answer)
        break