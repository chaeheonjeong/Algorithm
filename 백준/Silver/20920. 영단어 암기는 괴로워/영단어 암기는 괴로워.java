import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            if (s.length() >= M){
                words.put(s, words.getOrDefault(s, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        Collections.sort(list, (a, b) -> {
            if (a.getValue() == b.getValue()){
                if (b.getKey().length() == a.getKey().length()){
                    return a.getKey().compareTo(b.getKey());
                }
                return b.getKey().length() - a.getKey().length();
            }
            return b.getValue() - a.getValue();
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> x: list){
            sb.append(x.getKey()).append('\n');
        }

        System.out.println(sb);
    }
}
