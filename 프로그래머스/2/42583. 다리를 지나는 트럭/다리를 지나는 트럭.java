import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<int[]> que = new LinkedList<>();
        
        int curWeight = truck_weights[0];
        int curCount = 1;
        int curIdx = 1;
        int time = 1;
        // 무게, 현재 거리
        que.add(new int[] {truck_weights[0], 1});
        
        while(!que.isEmpty()){
            time++;
            
            int size = que.size();
            for(int i=0; i<size; i++){
                int[] now = que.poll();

                if(now[1] >= bridge_length){
                    curWeight -= now[0];
                    curCount--;
                } else {
                    now[1]++;
                    que.add(now);
                }
            }
            
            if(curIdx >= truck_weights.length) continue;
            if(truck_weights[curIdx] + curWeight <= weight &&
                curCount + 1 <= bridge_length) {
                que.add(new int[] {truck_weights[curIdx], 1});
                
                curWeight += truck_weights[curIdx];
                curCount++;
                curIdx++;
            }
        }
        
        return time;
    }
}