import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int y = maps.length;
        int x = maps[0].length;
        
        int[] dirY = {-1, 0, +1, 0};
        int[] dirX = {0, +1, 0 , -1};
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0});
        
        while(!que.isEmpty()){
            int[] now = que.poll();
            
            for(int i=0; i<4; i++){
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];
                
                if(newY < 0 || newY >= y || newX < 0 || newX >= x) continue;
                if(maps[newY][newX] == 0 || maps[newY][newX] > 1) continue;
                
                que.add(new int[] {newY, newX});
                maps[newY][newX] = maps[now[0]][now[1]] + 1;
            }
        }
        
        if(maps[y-1][x-1] == 1) answer = -1;
        else answer = maps[y-1][x-1];
        
        return answer;
    }
}