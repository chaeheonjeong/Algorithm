import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int[][] map;
    static final int[] dy = {-1, 0, +1, 0};
    static final int[] dx = {0, +1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true){

            if(map[r][c] == 0){
                map[r][c] = 2;
                answer += 1;
            }
            boolean flag = false;

            for (int i=0; i<4; i++){
                int ny = r + dy[i];
                int nx = c + dx[i];

                if (map[ny][nx] == 0){
                    flag = true;
                    goClean();
                    break;
                }
            }

            if (!flag){
                int td = (d + 2) % 4;
                r += dy[td];
                c += dx[td];

                if (map[r][c] == 1) break;
            }
        }

        System.out.println(answer);
    }

    static void goClean(){
        for (int i=0; i<4; i++){
            d -= 1;
            if (d == -1) d = 3;

            int ny = r + dy[d];
            int nx = c + dx[d];

            if(map[ny][nx] == 0){
                r = ny;
                c = nx;
                return;
            }
        }
    }
}
