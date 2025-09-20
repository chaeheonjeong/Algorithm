import copy

def solution(key, lock):
    KN = len(key)
    LN = len(lock)
    
    BN = LN + KN + KN -2
    
    board = [[0] * BN for _ in range(BN)]
    
    
    def printBoard():
        for y in range(BN):
            for x in range(BN):
                print(board[y][x], end="")
            print()
        print('-------------------------')
        
    def printKey():
        for y in range(KN):
            for x in range(KN):
                print(key[y][x], end="")
            print()
        print('-------------------------')
                 
    
    for y in range(KN-1, KN+LN-1):
        for x in range(KN-1, KN+LN-1):
            board[y][x] = lock[y-KN+1][x-KN+1]

    def rotate():
        temp = copy.deepcopy(key)
        
        for y in range(KN):
            for x in range(KN):
                key[x][KN-y-1] = temp[y][x]

    
    def fill(ty, tx):
        for y in range(KN):
            for x in range(KN):
                board[ty+y][tx+x] += key[y][x]
        
    
    def check():
        for y in range(KN-1, KN+LN-1):
            for x in range(KN-1, KN+LN-1):
                if not board[y][x] == 1:
                    return False  
        return True
        
        
    def delete(ty, tx):
        for y in range(KN):
            for x in range(KN):
                board[ty+y][tx+x] -= key[y][x]
        
            
    
    for y in range(BN-KN+1):
        for x in range(BN-KN+1):
            for i in range(4):
                rotate()
                fill(y, x)
                
                if check():
                    return True
                
                delete(y, x)
                        
                
    return False
            