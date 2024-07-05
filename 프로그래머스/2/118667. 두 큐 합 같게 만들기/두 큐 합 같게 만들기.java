import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Long sum1 = 0L;
        for(int x : queue1){
            que1.add(x);
            sum1 += x;
        }
        
        Queue<Integer> que2 = new LinkedList<>();
        Long sum2 = 0L;
        for(int x : queue2){
            que2.add(x);
            sum2 += x;
        }
        
        long target = (sum1 + sum2) / 2;
        
        int count = 0;
        while(true){
            if(count > queue1.length * 3) {
                count = -1;
                break;
            }
            if(sum1 == target && sum2 == target) break;
    
            if(sum1 > sum2){
                int a = que1.poll();
                if(a > target) {
                    count = -1;
                    break;
                }
                que2.add(a);
                sum1 -= a;
                sum2 += a;
            } else if(sum2 > sum1){
                int a = que2.poll();
                if(a > target){
                    count = -1;
                    break;
                }
                que1.add(a);
                sum2 -= a;
                sum1 += a;
            }
            count++;
        }
        
        return count;
    }
}