import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        int newY = 0;
        int newX = 0;
        
        for(char x: dirs.toCharArray()){
            int oldY = newY;
            int oldX = newX;
            
            if(x == 'U') newY++;
            else if(x == 'D') newY--;
            else if(x == 'R') newX++;
            else if(x == 'L') newX--;
            
            if(newY < -5 || newY > 5 || newX < -5 || newX > 5){
                newY = oldY;
                newX = oldX;
                continue;
            }
            
            boolean flag = true;
            String key = oldY + " " + oldX;
            String value = newY + " " + newX;
            
            if(map.containsKey(key)){
                for(String s: map.get(key)){
                    if((value).equals(s)) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(map.containsKey(value)){
                for(String s: map.get(value)){
                    if((key).equals(s)) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(flag) {
                if(map.containsKey(key)){
                    ArrayList<String> temp = map.get(key);
                    temp.add(value);
                    map.put(key, temp);
                } else{
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(value);
                    map.put(key, temp);
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}