import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] bus = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            bus[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bus[a].add(new int[] {b, v});
        }

        st  = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int dist = now[1];

            if(dist > result[node]) continue;

            for(int[] x: bus[node]){
                if(dist + x[1] < result[x[0]]){
                    pq.add(new int[] {x[0], dist + x[1]});
                    result[x[0]] = dist + x[1];
                }
            }
        }

        System.out.println(result[arrive]);
    }
}
