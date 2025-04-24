const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = parseInt(input.shift());
const M = parseInt(input.shift());

const arr = [];
for(let line of input){
    const [node1, node2, cost] = line.split(' ').map(Number);
    arr.push({node1, node2, cost});
}

function find(parent, x) {
    if(parent[x] === x) return x;

    return parent[x] = find(parent, parent[x]);
}

function union(parent, x, y) {
    let p1 = find(parent, x);
    let p2 = find(parent, y);

    if(p1 < p2) {
        parent[p2] = p1;
    } else {
        parent[p1] = p2;
    }
}

arr.sort((a, b) => a.cost - b.cost);
const parent = Array.from({length: N + 1}, (_, i)=>i);
let result = 0;
for(let {node1, node2, cost} of arr){
    if(find(parent, node1) !== find(parent, node2)){
        union(parent, node1, node2);
        result += cost;
    }
}

console.log(result);