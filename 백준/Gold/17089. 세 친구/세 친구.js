const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);

const friend = Array.from({length: N}, ()=> new Array(N).fill(false));
const friendCnt = new Array(N).fill(0);
for(let i=0; i<M; i++){
    const [a, b] = input.shift().split(' ').map(Number);
    friend[a-1][b-1] = true;
    friend[b-1][a-1] = true;
    friendCnt[a-1]++;
    friendCnt[b-1]++;
}

let min = Number.MAX_SAFE_INTEGER;
for(let i=0; i<N; i++){
    for(let j=i+1; j<N; j++){
        if(!friend[i][j]) continue;

        for(let k=j+1; k<N; k++){
            if(friend[j][k] && friend[k][i]){
                min = Math.min(friendCnt[i] + friendCnt[j] + friendCnt[k] - 6, min);
            }
        }
    }
}

console.log(min === Number.MAX_SAFE_INTEGER ? -1 : min);