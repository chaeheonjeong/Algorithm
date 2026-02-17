import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] item;
    static List<int[]>[] tree;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[a].add(new int[] {b, v});
            tree[b].add(new int[] {a, v});
        }

        for(int i=1; i<=n; i++){
            dikstra(i);
        }

        System.out.println(answer);
    }

    static void dikstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int now = t[0];
            int distance = t[1];

            if(dist[now] < distance) continue;

            for(int[] x: tree[now]){
                if(distance + x[1] < dist[x[0]]){
                    dist[x[0]] = distance + x[1];
                    pq.add(new int[] {x[0], distance + x[1]});
                }
            }
        }
        count(dist);
    }

    static void count(int[] dist){
        int result = 0;

        for (int i=1; i<=n; i++){
            if(dist[i] > m) continue;

            result += item[i];
        }

        answer = Math.max(result, answer);
    }
}
