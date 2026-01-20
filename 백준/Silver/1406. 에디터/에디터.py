import sys
input = sys.stdin.readline

left = list(input().rstrip())
N = int(input().rstrip())

right = []
for _ in range(N):
    t = input().split()

    if t[0] == 'L':
        if left:
            right.append(left.pop())
    elif t[0] == 'D':
        if right:
            left.append(right.pop())
    elif t[0] == 'B':
        if left:
            left.pop()
    else:  # 'P x'
        left.append(t[1])

sys.stdout.write(''.join(left) + ''.join(reversed(right)))
