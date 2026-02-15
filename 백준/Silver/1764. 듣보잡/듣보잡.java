import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i=0; i<N; i++){
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<M; i++){
            String t = br.readLine();
            if(set.contains(t)){
                result.add(t);
            }
        }
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');

        for (String x: result){
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }
}
