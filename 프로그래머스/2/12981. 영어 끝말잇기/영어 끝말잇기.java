import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        
        char last = words[0].charAt(words[0].length()-1);
        map.put(words[0], 1);
        for(int i=1; i<words.length; i++){
            char first = words[i].charAt(0);
            
            if(first != last || map.containsKey(words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            map.put(words[i], 1);
            last = words[i].charAt(words[i].length()-1);
        }
        

        return answer;
    }
}