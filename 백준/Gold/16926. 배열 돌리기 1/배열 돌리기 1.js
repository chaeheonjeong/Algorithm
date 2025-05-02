const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M, R] = input.shift().split(' ').map(Number);

let board = [];
for (let i = 0; i < N; i++) {
    board[i] = input.shift().split(' ').map(Number);
}

function rotate(temp, y1, x1, y2, x2) {
    for(let y=y2; y>y1; y--){
        temp[y][x1] = board[y-1][x1];
    }

    for(let y=y1; y<y2; y++){
        temp[y][x2] = board[y+1][x2];
    }

    for(let x=x1; x<x2; x++){
        temp[y2][x+1] = board[y2][x];
    }

    for(let x=x2; x>x1; x--){
        temp[y1][x-1] = board[y1][x];
    }
}

function copyArr() {
    const copy = Array.from({length: N}, ()=>new Array(M).fill(0));

    for (let i=0; i<N; i++){
        for (let j=0; j<M; j++){
            copy[i][j] = board[i][j];
        }
    }
    return copy;
}

for(let i=0; i<R; i++){
    let n = Math.min(N/2, M/2);
    const temp = copyArr();
    for(let j=0; j<n; j++){
        rotate(temp, j, j, N-1-j, M-1-j);
    }
    board = temp;
}

for(let y=0; y<N; y++){
    console.log(board[y].join(' '));
}
