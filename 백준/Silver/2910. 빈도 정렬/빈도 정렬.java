import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Long C = Long.parseLong(st.nextToken());

        Map<Integer, int[]> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if (map.containsKey(n)){
                int[] now = map.get(n);
                now[1]++;
                map.put(n, now);
            } else {
                map.put(n, new int[] {n, 1, i});
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int[] x: map.values()){
            result.add(x);
        }

        Collections.sort(result, (a, b) -> {
            if (a[1] == b[1]){
                return a[2] - b[2];
            }
            return b[1] - a[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] x: result){
            int n = 1;
            while(n <= x[1]){
                sb.append(x[0]).append(" ");
                n++;
            }
        }

        System.out.println(sb);
    }
}
