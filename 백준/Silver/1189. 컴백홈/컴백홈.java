import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};
    static int r, c, k;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];
        map = new String[r][c];
        for(int y=0; y<r; y++){
            map[y] = br.readLine().split("");
        }

        answer = 0;
        visited[r-1][0] = true;
        dfs(r-1, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int y, int x, int depth){
        if(y == 0 && x == c-1 && depth == k){
            answer++;
            return;
        }
        if(depth > k) return;

        for(int i=0; i<4; i++){
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if(newY < 0 || newY >= r || newX < 0 || newX >= c) continue;
            if(map[newY][newX].equals("T")) continue;

            if(!visited[newY][newX]) {
                visited[newY][newX] = true;
                dfs(newY, newX, depth + 1);
                visited[newY][newX] = false;
            }
        }
    }
}
