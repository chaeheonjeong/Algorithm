import java.util.*;
import java.io.*;

public class Main {
    // 왼쪽, 아래쪽, 오른쪽, 위쪽 (0, 1, 2, 3)
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};
    static List<Integer>[] cameras;

    static int N, M;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 6) {
                    visited[i][j] = true;
                }
            }
        }

        cameras = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            cameras[i] = new ArrayList<>();
        }
        cameras[1].add(2);
        cameras[2].add(0);
        cameras[2].add(2);
        cameras[3].add(2);
        cameras[3].add(3);
        cameras[4].add(0);
        cameras[4].add(2);
        cameras[4].add(3);
        cameras[5].add(0);
        cameras[5].add(1);
        cameras[5].add(2);
        cameras[5].add(3);

        dfs(0, 0, visited);

        System.out.println(answer);
    }

    static void dfs(int x, int y, boolean[][] visited) {
        if (y >= M){
            y = 0;
            x += 1;
        }
        if (x >= N){
            answer = Math.min(answer, count(visited));
            return;
        }

        if (map[x][y] == 6 || map[x][y] == 0){
            dfs(x, y+1, visited);
        } else {
            for (int i=0; i<4; i++){
                boolean[][] temp = copy(visited);
                watch(x, y, i, temp);
                dfs(x, y+1, temp);
            }
        }
    }

    static int count(boolean[][] visited) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }

    static void watch(int x, int y, int r, boolean[][] visited) {

        int num = map[x][y];
        List<Integer> directions = cameras[num];

        // d = 0 : 왼쪽
        // d = 1 : 아래쪽
        // d = 2 : 오른쪽
        // d = 3 : 위쪽
        // r : 회전 횟수
        for (int d: directions) {
            int ny = y, nx = x;
            d += r;
            d %= 4;

            while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(map[nx][ny] == 6) break;
                visited[nx][ny] = true;
                ny += dy[d];
                nx += dx[d];
            }
        }
    }

    static boolean[][] copy(boolean[][] visited) {
        boolean[][] target = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            // arraycopy(source, startIndex1, target, startIndex2, 몇 개?)
            System.arraycopy(visited[i], 0, target[i], 0, M);
        }

        return target;
    }

    static void print(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("————————————");
    }
}