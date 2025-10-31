N = int(input())

cnt = 0
while True:
    temp = N - (2 * cnt)

    if temp == 0:
        print(cnt)
        break
    elif temp % 5 == 0:
        print(cnt + temp //5)
        break
    elif temp < 0:
        print(-1)
        break

    cnt += 1