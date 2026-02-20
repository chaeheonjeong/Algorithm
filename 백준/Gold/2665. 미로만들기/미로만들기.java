import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for(int y=0; y<N; y++){
            String s = br.readLine();
            for (int x=0; x<N; x++){
                graph[y][x] = s.charAt(x) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        pq.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;

        int[] dy = {-1, 0, +1, 0};
        int[] dx = {0, +1, 0, -1};

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int y = now[0];
            int x = now[1];
            int distance = now[2];

            if (distance > dist[y][x]) continue;

            for (int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int value = graph[ny][nx] == 0 ? 1 : 0;
                if (dist[ny][nx] > distance + value) {
                    dist[ny][nx] = distance + value;
                    pq.offer(new int[] {ny, nx, distance + value});
                }
            }
        }

        System.out.println(dist[N-1][N-1]);
    }
}
