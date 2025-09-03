n = input()
t = len(n)//2

sum1 = 0
for i in range(t):
    sum1 += int(n[i])
    
sum2 = 0
for i in range(t, len(n)):
    sum2 += int(n[i])
    
if sum1 == sum2:
    print('LUCKY')
else:
    print('READY')