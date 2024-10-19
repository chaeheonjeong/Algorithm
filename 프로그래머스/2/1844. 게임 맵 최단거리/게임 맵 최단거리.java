import java.util.*;

class Solution {
    static int height;
    static int width;
    
    public int solution(int[][] maps) {
        
        height = maps.length;
        width = maps[0].length;
        bfs(maps);
        
        int answer = maps[height-1][width-1];
        return answer == 1 ? -1 : answer;
    }
    
    public static void bfs(int[][] maps){
        int[] dirY = {+1, 0, -1, 0};
        int[] dirX = {0, +1, 0, -1};
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0});
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            for(int i=0; i<4; i++){
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];
                
                if(newY < 0 || newY >= height || newX < 0 || newX >= width) continue;
                if(maps[newY][newX] == 0 || maps[newY][newX] > 1) continue;
                
                maps[newY][newX] = maps[now[0]][now[1]] + 1;
                que.add(new int[] {newY, newX});
            }
        }
    }
}