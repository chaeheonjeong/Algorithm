import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        
        answer = count;
        
        return answer;
    }
    
    public static void dfs(int now){
        for(int x: list[now]){
            if(!visited[x]){
                visited[x] = true;
                dfs(x);
            }
        }
    }
}