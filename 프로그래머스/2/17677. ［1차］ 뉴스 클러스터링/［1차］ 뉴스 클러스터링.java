import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String s = str1.substring(i, i+2).toLowerCase();
            
            if(isAlpha(s.charAt(0)) && isAlpha(s.charAt(1))){
                list1.add(s);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String s = str2.substring(i, i+2).toLowerCase();
            
            if(isAlpha(s.charAt(0)) && isAlpha(s.charAt(1))){
                list2.add(s);
            }
        }
        
        double totalCnt = list1.size();
        double dupCnt = 0;
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(list1.get(i).equals(list2.get(j))){
                    dupCnt++;
                    list2.remove(j);
                    break;
                }
            }
        }
        
        totalCnt += list2.size();
        
        if(totalCnt == 0) answer = 65536;
        else answer = (int)Math.floor((dupCnt / totalCnt) * 65536);
        
        return answer;
    }
    
    public boolean isAlpha(char c){
        return (c >= 'a' && c <= 'z');
    }
}