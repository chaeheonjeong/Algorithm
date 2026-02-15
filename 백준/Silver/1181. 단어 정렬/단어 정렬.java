import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        String[] result = new String[set.size()];
        int index = 0;
        for (String x: set){
            result[index] = x;
            index++;
        }

        Arrays.sort(result, (a, b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
