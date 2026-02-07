import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, v});
        }

        int[] dist = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int distance = now[1];

            if(dist[node] < distance) continue;

            for(int[] x: graph[node]){
                if (distance + x[1] < dist[x[0]]){
                    dist[x[0]] = distance + x[1];
                    pq.add(new int[] {x[0], distance + x[1]});
                }
            }
        }

        System.out.println(dist[arrive]);
    }
}
