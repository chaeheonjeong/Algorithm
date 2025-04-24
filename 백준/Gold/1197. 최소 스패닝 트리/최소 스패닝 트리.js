const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [V, E] = input.shift().split(' ').map(Number);
const lines = [];
for(let data of input){
    const [node1, node2, cost] = data.split(' ').map(Number);
    lines.push({node1, node2, cost});
}

function find(parent, node){
    if(parent[node] === node) return node;

    return parent[node] = find(parent, parent[node]);
}

function union(parent, node1, node2){
    let pa = find(parent, node1);
    let pb = find(parent, node2);

    if(pa < pb){
        parent[pb] = pa;
    } else {
        parent[pb] = pa;
    }
}

lines.sort((a, b) => a.cost - b.cost);
let answer = 0;
const parent = Array.from({length: V+1}, (_, i)=> i);
for(let {node1, node2, cost} of lines){
    if(find(parent, node1) !== find(parent, node2)){
        union(parent, node1, node2);
        answer += cost;
    }
}

console.log(answer);