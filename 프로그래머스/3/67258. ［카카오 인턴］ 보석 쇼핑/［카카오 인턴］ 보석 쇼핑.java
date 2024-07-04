import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<gems.length; i++){
            hs.add(gems[i]);
        }
        int size = hs.size();
        
        for(int i=0; i<size; i++){
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1);
        }
        
        if(hm.size() == size){
            return new int[]{1, size};
        }
        
        int now_s = 0;
        int now_e = size - 1;
        int s = 0;
        int e = size - 1;
        int length = Integer.MAX_VALUE;
        for(int i=size; i<gems.length; i++){
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1);
            now_e++;
            
            while(true){
                if(hm.get(gems[now_s]) == 1) break;
                
                hm.put(gems[now_s], hm.get(gems[now_s]) - 1);
                now_s++;
            }
            
            if(hm.size() == size && now_e - now_s < length){
                length = now_e - now_s;
                s = now_s;
                e = now_e;
                
                if(length + 1 == size) break;
            }
        }
        
        answer[0] = s + 1;
        answer[1] = e + 1;
        
        return answer;
    }
}