import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        double s1 = getLength(str1);
        double s2 = getLength(str2);
        
        if(s1 == 0 && s2 == 0) return 65536;
        
        double dup_s = getDupLength(str1, str2);
        
        double result = dup_s / (s1 + s2 - dup_s);
        answer = (int)Math.floor(result * 65536);
        
        return answer;
    }
    
    public static int getLength(String str){
        int cnt = 0;
        for(int i=0; i<str.length()-1; i++){
            boolean flag = false;
            String tmp = str.substring(i, i+2);
            
            for(char x: tmp.toCharArray()){
                if(!(x >= 'a' && x <= 'z')) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) cnt++;
        }
        
        return cnt;
    }
    
    public static int getDupLength(String str1, String str2){
        int cnt = 0;
        List<String> str2List = new ArrayList<>();
        for(int i=0; i<str2.length()-1; i++){
            str2List.add(str2.substring(i, i+2));
        }
        
        for(int i=0; i<str1.length()-1; i++){
            boolean flag = false;
            String tmp = str1.substring(i, i+2);
            
            for(char x: tmp.toCharArray()){
                if(!(x >= 'a' && x <= 'z')) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag && str2List.contains(tmp)) {
                cnt++;
                str2List.remove(tmp);
            }
        }
        
        return cnt;
    }
}