const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [n, m] = input.shift().split(' ').map(Number);
const map = [];
const visited = Array.from({length: n}, () => Array(m).fill(false));
const dirY = [-1, 0, +1, 0];
const dirX = [0, +1, 0, -1];

for (let i = 0; i < n; i++) {
    map[i] = input[i].split('').map(Number);
}

function bfs() {
    const que = [];
    que.push([0, 0, 1]);
    visited[0][0] = true;

    while (que.length) {
        const [y, x, move] = que.shift();
        if(y === n-1 && x === m-1) return move;

        for (let i = 0; i < 4; i++) {
            let newY = y + dirY[i];
            let newX = x + dirX[i];

            if(newY < 0 || newY >= n || newX < 0 || newX >= m) continue;
            if(visited[newY][newX] || map[newY][newX] === 0) continue;

            que.push([newY, newX, move+1]);
            visited[newY][newX] = true;
        }
    }
}

console.log(bfs());