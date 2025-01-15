import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();
        
        for(int i=0; i<26; i++){
            char c = (char)('A' + i);
            words.put(String.valueOf(c), i+1);
        }
        
        int length = msg.length();
        int lt = 0, rt = 0;
        while(rt < length){
            String temp = msg.substring(lt, rt+1);
                
            if(!words.containsKey(temp)){
                String w = msg.substring(lt, rt);
                
                result.add(words.get(w));
                words.put(temp, words.size()+1);
                lt = rt;
            }
            
            rt++;
        }
        
        result.add(words.get(msg.substring(lt, rt)));
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}