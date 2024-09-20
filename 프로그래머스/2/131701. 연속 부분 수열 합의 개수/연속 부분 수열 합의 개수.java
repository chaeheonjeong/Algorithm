import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int size=1; size<=elements.length; size++){
            for(int i=0; i<elements.length; i++){
                int sum = 0;
                
                for(int j=i; j<i+size; j++){
                    int idx = j % elements.length;
                    sum += elements[idx];
                }
                
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}