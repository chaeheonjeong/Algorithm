const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = Number(input.shift());
const numArr = input[0].split(' ').map(BigInt);
const visited = new Array(N).fill(false);
let done = false;

function dfs(stack, now) {
    if (stack.length > 1) {
        const f = stack[now-2];
        const b = stack[now-1];
        if((f % 3n !== 0n || f / 3n !== b) && f * 2n !== b) return;
    }
    if (now >= N) {
        if (!done) {
            console.log(stack.join(' '));
            done = true;
        }
        return;
    }

    for (let i = 0; i < N; i++) {
        if (!visited[i]) {
            visited[i] = true;
            stack.push(numArr[i]);
            dfs(stack, now + 1);
            stack.pop();
            visited[i] = false;
        }
    }
}

dfs([], 0);
