import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(isGroupWord(s)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isGroupWord(String s){
        Map<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                if(hm.get(c) != i-1) return false;
            }

            hm.put(c, i);
        }

        return true;
    }
}
