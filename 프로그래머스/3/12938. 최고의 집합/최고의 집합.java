import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) return new int[] {-1};
        
        int[] result = new int[n];
        
        int a = s/n;
        int mod = s%n;
        
        Arrays.fill(result, a);
        
        if(mod != 0){
            for(int i=n-1; i>=n-mod; i--){
                result[i] = a+1;
            }
        }
        
        return result;
    }
}