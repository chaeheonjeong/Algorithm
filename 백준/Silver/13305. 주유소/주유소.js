const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input[0]);
let dist = input[1].split(' ').map(BigInt);
let price = input[2].split(' ').map(BigInt);

let result = 0n;

let lt = 0, rt = 0;
function sum(start, end){
    for(let i=start; i<end; i++){
        result += dist[i] * price[start];
    }
}

while(rt < n){
    if(price[lt] > price[rt]){
        sum(lt, rt);
        lt = rt;
    }

    rt++;
}

if(lt !== n-1){
    sum(lt, n-1);
}

console.log(String(result));