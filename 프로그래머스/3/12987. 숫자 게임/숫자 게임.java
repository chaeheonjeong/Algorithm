import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> c = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x: A){
            a.add(x);
        }
        for(int x: B){
            b.add(x);
        }
        
        int answer = 0;
        while(!a.isEmpty()){
            int nowA = a.poll();
            int nowB = b.poll();
            
            if(nowB > nowA){
                answer++;
            } else{
                c.add(nowB);
                
                if(c.peek() > nowA){
                    c.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}