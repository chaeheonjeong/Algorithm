const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let n = parseInt(input[0]);
let arr = [];

for(let i = 1; i<=n; i++){
    let [weight, height] = input[i].split(' ').map(Number);
    arr.push([weight, height]);
}

let result = [];
for(let i=0; i<n; i++){
    let cnt = 1;

    for(let j=0; j<n; j++){
        if(i === j) continue;

        if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
    }

    result.push(cnt);
}

console.log(result.join(' '));