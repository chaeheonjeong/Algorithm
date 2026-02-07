import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for(int y=0; y<N; y++){
            String input = br.readLine();
            for(int x=0; x<M; x++){
                board[y][x] = input.charAt(x) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] distance = new int[N][M];
        for(int i=0; i<N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        pq.add(new int[]{0, 0, 0});
        distance[0][0] = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int y = now[0], x = now[1], dist = now[2];
            if(distance[y][x] < dist) continue;

            for (int d=0; d<4; d++){
                int ny = y+dy[d], nx = x+dx[d];
                if(ny<0 || ny >= N || nx<0 || nx>=M) continue;

                int cost = board[ny][nx] == 0 ? dist : dist + 1;
                if(cost < distance[ny][nx]){
                    distance[ny][nx] = cost;
                    pq.add(new int[]{ny, nx, cost});
                }
            }
        }

        System.out.println(distance[N-1][M-1]);
    }

}
