let visited = [];
let tree = [];
let N = 0;
let answer = Number.MAX_SAFE_INTEGER;

function dfs(now){
    visited[now] = true;
    
    let sum = 0;
    for(let x of tree[now]){
        if(!visited[x]){
            sum += dfs(x);
        }
    }
    
    sum++;
    answer = Math.min(answer, Math.abs(sum - (N-sum)));
    return sum;
}

function solution(n, wires) {
    N = n;
    visited = new Array(n).fill(false);
    tree = Array.from({length: n}, () => []);
    
    for(let [a, b] of wires){
        tree[a-1].push(b-1);
        tree[b-1].push(a-1);
    }
    
    dfs(0);
    
    return answer;
}