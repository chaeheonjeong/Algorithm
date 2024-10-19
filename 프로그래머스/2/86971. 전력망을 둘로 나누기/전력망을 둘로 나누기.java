import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] list;
    static int[] count;
    
    public int solution(int n, int[][] wires) {
        int answer = 0;
        
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        count = new int[n+1];
        dfs(1);
        
        int min = -1;
        int minV = Integer.MAX_VALUE;
        int piv = n / 2;
        for(int x: count){
            if(Math.abs(piv - x) < minV){
                minV = Math.abs(piv - x);
                min = x;
            }
        }
        
        answer = Math.abs((n-min) - min);
        
        return answer;
    }
    
    public static int dfs(int now){
        visited[now] = true;
        
        for(int x: list[now]){
            if(!visited[x]){
                count[now] += dfs(x);
            }
        }
        
        count[now]++;
        return count[now];
    }
}