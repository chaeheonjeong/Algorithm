N = int(input())
files = [input() for _ in range(N)]

result = {}
for x in files:
    file = x.split('.')
    result[file[1]] = result.get(file[1], 0) + 1

keys = list(result.keys())
keys.sort()

for key in keys:
    print(key, result[key])