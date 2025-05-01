const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input.shift());
const form = input.shift();
let result = Number.MIN_SAFE_INTEGER;

function calculate(a, b, op) {
    if (op === '+') return a + b;
    else if (op === '-') return a - b;
    else if (op === '*') return a * b;
}

function dfs(now, acc) {
    if (now >= n) {
        result = Math.max(result, acc);
        return;
    }

    if(now < n-1){
        const sum = calculate(parseInt(form[now]), parseInt(form[now + 2]), form[now + 1]);
        // 괄호 사용
        dfs(now + 4, calculate(acc, sum, form[now - 1]));
    }

    // 괄호 미사용
    dfs(now + 2, calculate(acc, parseInt(form[now]), form[now - 1]));
}

dfs(2, parseInt(form[0]));
console.log(result);