const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input.shift().split(' ').map(Number);
const board = input.map((row) => row.split(' ').map(Number));
const chicken = [];
const home = [];
let min = Number.MAX_SAFE_INTEGER;

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (board[i][j] === 2) chicken.push([i, j]);
        else if (board[i][j] === 1) home.push([i, j]);
    }
}

function getDist(arr) {
    let sum = 0;
    for (let i = 0; i < home.length; i++) {
        let min = Number.MAX_SAFE_INTEGER;
        for (let j of arr) {
            min = Math.min(min, Math.abs(home[i][0] - chicken[j][0]) + Math.abs(home[i][1] - chicken[j][1]));
        }

        sum += min;
    }
    return sum;
}

function dfs(target, now, arr, depth) {
    if (depth === target) {
        min = Math.min(min, getDist(arr));
        return;
    }

    for (let i = now; i < chicken.length; i++) {
        arr.push(i);
        dfs(target, i + 1, arr, depth + 1);
        arr.pop();
    }
}

for (let i = 1; i <= M; i++) {
    dfs(i, 0, [], 0);
}

console.log(min);