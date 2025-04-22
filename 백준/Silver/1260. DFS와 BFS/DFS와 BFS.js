const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, m, v] = input[0].split(' ').map(Number);
let graph = new Array(n+1);

for(let i=0; i <= n; i++){
    graph[i] = [];
}

for(let i=1; i<=m; i++){
    let [from, to] = input[i].split(' ').map(Number);
    graph[from].push(to);
    graph[to].push(from);
}

for(let i=1; i<=n; i++){
    graph[i].sort((a, b) => a- b);
}

let result = [];
let visited = new Array(n+1).fill(false);

function dfs(now){
    result.push(now);

    for(let x of graph[now]){
        if(!visited[x]){
            visited[x] = true;
            dfs(x);
        }
    }
}

function bfs(start){
    let queue = [];
    queue.push(start);

    while(queue.length !== 0){
        let now = queue.shift();
        result.push(now);

        for(let x of graph[now]){
            if(!visited[x]){
                visited[x] = true;
                queue.push(x);
            }
        }
    }
}

visited[v] = true;
dfs(v);
console.log(result.join(' '));

result = [];
visited.fill(false);
visited[v] = true;
bfs(v);
console.log(result.join(' '));