import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[] result;
    static int N = 11;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            map = new int[N][N];
            for (int y=0; y<N; y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<N; x++){
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            result = new boolean[N];
            Arrays.fill(result, false);
            answer = Integer.MIN_VALUE;

            dfs(0, 0);

            System.out.println(answer);
        }
    }

    static void dfs(int depth, int sum){
        if (depth == N){
            answer = Math.max(answer, sum);
        }

        for (int i=0; i<N; i++){
            if (!result[i] && map[depth][i] != 0){
                result[i] = true;
                dfs(depth+1, sum + map[depth][i]);
                result[i] = false;
            }
        }
    }
}
