import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        for(int i=0; i<cities.length; i++){
            if(cache.contains(cities[i])){
                cache.remove(cities[i]);
                answer++;
            } else {
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                answer += 5;
            }
            cache.add(cities[i]);
        }
        
        return answer;
    }
}