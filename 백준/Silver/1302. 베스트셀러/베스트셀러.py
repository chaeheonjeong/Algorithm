N = int(input())

books = {}
for _ in range(N):
    s = input()
    books[s] = books.get(s, 0) + 1

sorted_books = sorted(books.items(), key=lambda x:(-x[1], x[0]))

print(sorted_books[0][0])