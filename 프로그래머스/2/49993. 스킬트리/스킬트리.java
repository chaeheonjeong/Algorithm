import java.util.*;

class Solution {
    static Queue<String> que;
    
    public int solution(String skill, String[] skill_trees) {
        que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<skill.length(); i++){
            String temp = skill.substring(i, i+1);
            set.add(temp);
        }
        
        int answer = 0;
        for(String s: skill_trees){
            String[] tempArr = s.split("");
            setQueue(skill);
            
            boolean flag = true;
            for(String x: tempArr){
                if(que.isEmpty()) break;
                
                if(set.contains(x)){
                    if(que.peek().equals(x)){
                        que.poll();
                    } else{
                        flag = false;
                        break;
                    }
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    public static void setQueue(String skill){
        que.clear();
        
        for(int i=0; i<skill.length(); i++){
            String temp = skill.substring(i, i+1);
            que.add(temp);
        }
    }
}