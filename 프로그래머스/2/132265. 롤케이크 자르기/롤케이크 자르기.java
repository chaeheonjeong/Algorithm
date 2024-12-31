import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> older = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        if(topping.length == 1) return 0;
        
        for(int i=0; i<topping.length; i++){
            younger.put(topping[i], younger.getOrDefault(topping[i], 0)+1);
        }
        
        int answer = 0;
        for(int i=0; i<topping.length; i++){
            older.put(topping[i], older.getOrDefault(topping[i], 0)+1);
            
            if(younger.get(topping[i]) > 1){
                younger.put(topping[i], younger.get(topping[i])-1);
            } else{
                younger.remove(topping[i]);
            }
            
            if(older.size() == younger.size()){
                answer++;
            }
        }
        
        return answer;
    }
}