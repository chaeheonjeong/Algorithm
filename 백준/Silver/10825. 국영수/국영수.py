N = int(input())

arr = [] * N

for _ in range(N):
    arr.append(list(input().split()))

def sort_info(i):
    return (-int(arr[i][1]), int(arr[i][2]), -int(arr[i][3]), arr[i][0])

result = sorted(range(N), key = sort_info)

for x in result:
    print(arr[x][0])