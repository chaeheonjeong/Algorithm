def solution(order):
    answer = 0
    
    cont = []
    idx = 0
    target = 1
    
    while idx < len(order):
        if order[idx] == target:
            answer += 1
            idx += 1
            target += 1
        elif order[idx] > target:
            while target != order[idx]:
                cont.append(target)
                target += 1
        else:
            now = cont.pop()
            if order[idx] == now:
                answer += 1
                idx += 1
            else:
                break
                
    
    return answer