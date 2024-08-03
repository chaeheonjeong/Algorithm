import java.util.*;

class Solution {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static String[] words;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        this.words = words;
        
        dfs(begin, target, 0);
        
        return (min == Integer.MAX_VALUE ? 0 : min);
    }
    
    public static void dfs(String now, String target, int depth){
        if(now.equals(target)){
            min = Math.min(depth, min);
            return;
        } else if(depth >= min){
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if(!visited[i] && isOneDiff(now, words[i])){
                visited[i] = true;
                dfs(words[i], target, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isOneDiff(String a, String b){
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
            if(count >= 2) return false;
        }
        
       return (count == 1);
    }
}