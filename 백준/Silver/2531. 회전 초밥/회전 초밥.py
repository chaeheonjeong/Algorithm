N, d, k, c = map(int, input().split())
sushi = [int(input()) for _ in range(N)]

_set = set()
_set.add(c)

dict = {}
dict[c] = 1

for i in range(k):
    _set.add(sushi[i])
    dict[sushi[i]] = dict.get(sushi[i], 0) + 1

answer = len(_set)

start = 0
end = k-1
while start < N:
    dict[sushi[start]] = dict.get(sushi[start])-1

    if dict[sushi[start]] == 0:
        dict.pop(sushi[start], None)
        _set.remove(sushi[start])
    
    start += 1
    end = (end+1) % N

    dict[sushi[end]] = dict.get(sushi[end], 0) + 1
    _set.add(sushi[end])

    answer = max(answer, len(_set))


print(answer)