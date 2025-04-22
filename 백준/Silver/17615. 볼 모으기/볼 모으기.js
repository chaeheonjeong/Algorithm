const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input[0]);
const s = input[1];


// 처음 시작이 R 이면서 왼쪽
let cnt = 0;
let flag = true;
for(let i=0; i<n; i++){
    if(s[i] === 'R'){
        if(flag) continue;
        cnt++;
    }

    flag = false;
}
let min = cnt;

// 처음 시작이 R 이면서 오른쪽
cnt = 0;
flag = true;
for(let i=n-1; i>=0; i--){
    if(s[i] === 'R'){
        if(flag) continue;
        cnt++;
    }

    flag = false;
}
min = Math.min(min, cnt);

// 처음 시작이 B 이면서 왼쪽
cnt = 0;
flag = true;
for(let i=0; i<n; i++){
    if(s[i] === 'B'){
        if(flag) continue;
        cnt++;
    }

    flag = false;
}
min = Math.min(min, cnt);


cnt = 0;
flag = true;
for(let i=n-1; i>=0; i--){
    if(s[i] === 'B'){
        if(flag) continue;
        cnt++;
    }

    flag = false;
}
min = Math.min(min, cnt);

console.log(min);