import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};
    static int n;
    static int l;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            answer++;

            for(boolean[] x : visited){
                Arrays.fill(x, false);
            }

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (!visited[y][x]) {
                        if(bfs(y, x)) flag = true;
                    }
                }
            }
        }

        System.out.println(answer-1);
    }

    public static boolean bfs(int startY, int startX){
        ArrayList<int[]> country = new ArrayList<>();
        visited[startY][startX] = true;
        country.add(new int[]{startY, startX});

        int p = 0;
        int sum = 0;
        while(p < country.size()) {
            int[] now = country.get(p);
            sum += map[now[0]][now[1]];
            p++;

            for (int i = 0; i < 4; i++) {
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];

                if (newY < 0 || newY >= n || newX < 0 || newX >= n) continue;
                int dif = Math.abs(map[newY][newX] - map[now[0]][now[1]]);

                if (!visited[newY][newX] && dif >= l && dif <= r) {
                    visited[newY][newX] = true;
                    country.add(new int[]{newY, newX});
                }
            }
        }

        int newSum = sum / country.size();
        for(int[] x: country){
            map[x[0]][x[1]] = newSum;
        }

        return p != 1;
    }
}
