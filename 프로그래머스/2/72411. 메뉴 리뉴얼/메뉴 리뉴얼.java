import java.util.*;

class Solution {
    static String all = "";
    static ArrayList<String> answer;
    static String[] orders;
    static ArrayList<String> tempAnswer;
    static int max = Integer.MIN_VALUE;
    
    public String[] solution(String[] ordersInput, int[] course) {
        answer = new ArrayList<>();
        tempAnswer = new ArrayList<>();
        orders = ordersInput;
        
        // 중복되지 않는 알파벳만 추출
        for(String s: orders){
            for(int i = 0; i < s.length(); i++){
                String alpha = s.substring(i, i + 1);
                if(!all.contains(alpha)){
                    all += alpha;
                }
            }
        }
        
        for(int c : course){
            tempAnswer.clear();
            max = Integer.MIN_VALUE;
            dfs(c, 0, 0, "");
            
            for(String s : tempAnswer){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                answer.add(new String(chars));
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    public static void dfs(int target, int depth, int now, String s){
        if(depth == target){
            int cnt = 0;
            
            for(String order : orders){
                boolean flag = true;
                for(int j = 0; j < s.length(); j++){
                    if(!order.contains(s.substring(j, j + 1))){
                        flag = false;
                        break;
                    }
                }
                
                if(flag) cnt++;
            }
            
            if(cnt >= 2 && cnt > max){
                max = cnt;
                tempAnswer.clear();
                tempAnswer.add(s);
            } else if(cnt == max){
                tempAnswer.add(s);
            }
            
            return;
        }
        
        for(int i = now; i < all.length(); i++){
            dfs(target, depth + 1, i + 1, s + all.substring(i, i + 1));
        }
    }
}
