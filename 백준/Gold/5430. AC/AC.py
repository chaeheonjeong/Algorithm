from collections import deque

T = int(input())

def convertArr(s):
    comma = s[1:-1] # ''
    if comma == '':
        return []

    return comma.split(',')

for _ in range(T):
    p = input()
    n = int(input())
    arr = convertArr(input())

    que = deque(arr)
    dir = True

    flag = False
    for i in range(len(p)):
        if p[i] == 'R':
            dir = not dir
        else:
            if not que:
                print("error")
                flag = True
                break

            if dir:
                que.popleft()
            else:
                que.pop()
    
    if flag:
        continue
    if dir:
        print('[' + ','.join(list(que)) + ']')
    else:
        print('[' + ','.join(list(que)[::-1]) + ']')