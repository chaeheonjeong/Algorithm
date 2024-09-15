import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length() < m) continue;

            map.put(s, map.getOrDefault(s, 0)+1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((w1, w2) -> {
            int freq1 = map.get(w1);
            int freq2 = map.get(w2);

            if(freq1 != freq2){
                return freq2 - freq1;
            } else if(w1.length() != w2.length()){
                return w2.length() - w1.length();
            } else{
                return w1.compareTo(w2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s: words){
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
