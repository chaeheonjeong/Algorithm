import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int H;
    static int[][] map;
    static int answer = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];
        for(int i=1; i<=H; i++){
            Arrays.fill(map[i], 0);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        dfs(1, 1, 0);

        if (answer == 4){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void dfs(int y, int x, int depth){
        if (isAnswer()){
            answer = Math.min(answer, depth);
            return;
        }
        if (depth == 3){
            return;
        }

        if (x >= N) {
            y++;
            x = 1;
        }
        if (y > H) return;

        if (map[y][x] != 1 && map[y][x-1] != 1 && map[y][x+1] != 1){
            map[y][x] = 1;
            dfs(y, x + 2, depth +1);
            map[y][x] = 0;
        }
        dfs(y, x + 1, depth);
    }

    static boolean isAnswer(){
        for (int i=1; i<=N; i++){
            int y = 1, x = i;
            while(y <= H && x <= N){
                if (map[y][x] == 1) {
                    x++;
                } else if (map[y][x - 1] == 1){
                    x--;
                }
                y++;
            }
            if (x != i) return false;
        }
        return true;
    }
}
