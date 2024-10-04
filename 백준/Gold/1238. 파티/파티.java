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
        int x = Integer.parseInt(st.nextToken());

        int[][] dis = new int[n+1][n+1];
        List<int[]>[] list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[a].add(new int[] {b, v});
        }


        for(int i=1; i<=n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        for(int i=1; i<=n; i++){
            PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            que.add(new int[] {i, 0});

            while(!que.isEmpty()){
                int[] poll = que.poll();
                int now = poll[0];
                int dist = poll[1];

                if(dist > dis[i][now]) continue;

                for(int[] t: list[now]){
                    if(dis[i][t[0]] > dist + t[1]){
                        que.add(new int[] {t[0], dist + t[1]});
                        dis[i][t[0]] = dist + t[1];
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(i == x) continue;
            answer = Math.max(answer, dis[i][x] + dis[x][i]);
        }

        System.out.println(answer);
    }
}
