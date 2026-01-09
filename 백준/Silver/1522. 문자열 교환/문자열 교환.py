S = input()

an = 0
bn = 0
for x in S:
    if x == 'a':
        an += 1
    else:
        bn += 1

T = ''
for i in range(an):
    T += 'a'
for i in range(bn):
    T += 'b'


def countDiff(a, b):
    result = 0
    for i in range(len(a)):
        if not a[i] == b[i]:
            result += 1
    
    return result


ans = int(1e9)
for i in range(len(S)):
    cnt = countDiff(S, T)
    ans = min(cnt, ans)
    T = T[1:] + T[0]

print(ans//2)