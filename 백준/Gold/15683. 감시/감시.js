const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const dirY = [-1, 0, +1, 0];
const dirX = [0, +1, 0, -1];
const watchAvail = [[0], [0, 2], [0,1], [0,1,2], [0,1,2,3]];

const[N, M] = input.shift().split(' ').map(Number);
let board = input.map((row) => row.split(' ').map(Number));
let result = Number.MAX_SAFE_INTEGER;

const cctv = [];
let cnt = 0;
for(let y=0; y<N; y++){
    for(let x=0; x<M; x++){
        if(board[y][x] === 0 || board[y][x] === 6) continue;

        cctv.push([y, x]);
        cnt++;
    }
}

function watch(y, x, type, startDir){
    const dirWatch = watchAvail[type];

    for(let d of dirWatch){
        const curDir = (startDir + d) % 4;
        let tmpY = y;
        let tmpX = x;

        while(true){
            const newY = tmpY + dirY[curDir];
            const newX = tmpX + dirX[curDir];

            tmpY = newY;
            tmpX = newX;

            if(newY < 0 || newX < 0 || newY >= N || newX >= M) break;
            if(board[newY][newX] === 6) break;
            if(board[newY][newX] !== 0) continue;

            board[newY][newX] = -1;
        }
    }
}

function dfs(depth){
    if(depth === cnt){
        let size = 0;
        for(let i=0; i<N; i++){
            for(let j=0; j<M; j++){
                if(board[i][j] === 0) size += 1;
            }
        }

        result = Math.min(result, size);
        return;
    }

    const [y, x] = cctv[depth];

    for(let i=0; i<4; i++){
        const tmp = board.map((row) => [...row]);

        watch(y, x, board[y][x]-1, i);
        dfs(depth+1);

        board = tmp.map((row) => [...row]);
    }
}

dfs(0);
console.log(result);