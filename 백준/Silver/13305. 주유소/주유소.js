const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = parseInt(input[0]);
let dist = input[1].split(' ').map(Number);
let price = input[2].split(' ').map(Number);

let result = 0;

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

console.log(result);