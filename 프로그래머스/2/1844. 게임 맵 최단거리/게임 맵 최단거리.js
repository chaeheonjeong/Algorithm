const dirY = [-1, 0, +1, 0];
const dirX = [0, +1, 0, -1];
let board;
let visited;
let N, M;

function bfs() {
    const que = [];
    que.push([0, 0]);
    visited[0][0] = true;
    
    while(que.length){
        const now = que.shift();
        
        for(let i=0; i<4; i++){
            const newY = now[0] + dirY[i];
            const newX = now[1] + dirX[i];
            
            if(newY < 0 || newX < 0 
               || newY >= N || newX >= M) continue;
            if(board[newY][newX] === 0 || visited[newY][newX]) continue;
            
            que.push([newY, newX]);
            visited[newY][newX] = true;
            board[newY][newX] = board[now[0]][now[1]]+1;
        }
    }
}

function solution(maps) {
    board = maps;
    N = board.length;
    M = board[0].length;
    visited = Array.from({length: N}, () => new Array(M).fill(false));
    
    bfs();
    
    return board[N-1][M-1] === 1 ? -1 : board[N-1][M-1];
}