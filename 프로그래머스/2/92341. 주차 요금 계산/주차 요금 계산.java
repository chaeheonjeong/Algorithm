import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] result = new int[10000];
        
        for(int i=0; i<records.length-1; i++){
            String[] now = records[i].split(" ");
            
            if(now[2].equals("OUT")) continue;
            
            boolean flag = false;
            int time = 0;
            for(int j=i+1; j<records.length; j++){
                String[] next = records[j].split(" ");
                
                if(now[1].equals(next[1])){
                    time = getTime(fees, now[0], next[0]);
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                time = getTime(fees, now[0], "23:59");
            }
                
            result[Integer.parseInt(now[1])] += time;
        }
        
        String[] temp = records[records.length-1].split(" ");
        if(temp[2].equals("IN")){
            result[Integer.parseInt(temp[1])] += getTime(fees, temp[0], "23:59");
        }
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<10000; i++){
            if(result[i] != 0) answer.add(result[i]);
        }
        
        int[] answerArr = new int[answer.size()];
        for (int j = 0; j < answer.size(); j++) {
            int totalTime = answer.get(j);
            if (totalTime > fees[0]) {
                answerArr[j] = fees[1] + (totalTime - fees[0] + fees[2] - 1) / fees[2] * fees[3];
            } else {
                answerArr[j] = fees[1];
            }
        }
        
        return answerArr;
        
    }
    
    public static int getTime(int[] fees, String in, String out){
        String[] s1 = in.split(":");
        String[] s2 = out.split(":");
        
        int inTotal = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
        int outTotal = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
        
        return outTotal - inTotal;
    }
}