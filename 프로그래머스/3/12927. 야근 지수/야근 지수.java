import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : works){
            que.add(x);
        }
        
        while(n > 0){
            if(que.isEmpty()) break;
            int t = que.poll();
            if(t > 1){
                que.add(t-1);
            }
            n--;
        }
        
        while(!que.isEmpty()){
            int t = que.poll();
            answer += t * t;
        }
        
        return answer;
    }
}