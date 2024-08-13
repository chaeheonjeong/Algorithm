import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] position;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testcase = Integer.parseInt(st.nextToken());
        for(int t=0; t<testcase; t++){
            position = new int[11][11];
            visited = new boolean[11];
            max = Integer.MIN_VALUE;

            for(int y=0; y<11; y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<11; x++){
                    position[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0);
            System.out.println(max);
        }
    }

    public static void dfs(int depth, int ability, int x){
        if(depth == 11){
            max = Math.max(max, ability);
            return;
        }

        for(int y=0; y<11; y++){
            if(!visited[y] && position[y][x] != 0){
                visited[y] = true;
                dfs(depth+1, ability + position[y][x], x+1);
                visited[y] = false;
            }
        }
    }
}
