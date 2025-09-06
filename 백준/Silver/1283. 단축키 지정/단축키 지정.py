N = int(input())
words = [input() for _ in range(N)]


def printWord(idx, word):
    result = ''
    for i in range(len(word)):
        if i == idx:
            result = result + '[' + word[i] + ']'
        else:
            result = result + word[i]

    print(result)


used = set()
# word = Save As
for word in words:

    flag = False
    for i in range(len(word)):
        if (word[i-1] == ' ' or i == 0)and word[i].lower() not in used:
            flag =True
            used.add(word[i].lower())
            printWord(i, word)
            break

    if not flag:
        flag = False
        for i in range(len(word)):
            if word[i] != ' ' and word[i].lower() not in used:
                flag = True
                used.add(word[i].lower())
                printWord(i, word)
                break

    if not flag:
        print(word)
