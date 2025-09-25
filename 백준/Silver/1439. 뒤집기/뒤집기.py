s = input()
s += '5'

zero = 0
one = 0
prev = s[0]

for i in range(len(s)):
    if prev == s[i]:
        continue
    else:
        if prev == '0':
            zero += 1
        else:
            one += 1
        prev = s[i]


answer = min(zero, one)
print(answer)