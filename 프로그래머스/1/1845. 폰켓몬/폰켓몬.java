import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> poketmon = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            poketmon.put(nums[i], 0);
        }
        
        int num = nums.length / 2;
        int cnt = poketmon.keySet().size();
        
        if(num > cnt){
            answer = cnt;
        } else {
            answer = num;
        }
        
        return answer;
    }
}