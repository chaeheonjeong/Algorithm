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

        int[] dis = new int[n+1];
        List<int[]>[] list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[a].add(new int[] {b,v});
            list[b].add(new int[] {a,v});
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        que.add(new int[]{1, 0});

        while(!que.isEmpty()){
            int[] poll = que.poll();
            int now = poll[0];
            int dist = poll[1];

            if(dist > dis[now]) continue;

            for(int[] t: list[now]){
                if(dis[t[0]] > dist + t[1]){
                    dis[t[0]] = dist + t[1];
                    que.add(new int[] {t[0], dist + t[1]});
                }
            }
        }


        System.out.println(dis[n]);
    }
}
