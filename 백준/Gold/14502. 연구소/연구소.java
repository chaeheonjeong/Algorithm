import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> area;
    static List<int[]> virus;
    static int[][] map;
    static boolean[] visited;
    static int aN;
    static int vN;
    static int answer;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        area = new ArrayList<>();
        virus = new ArrayList<>();
        for (int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());

                if (map[y][x] == 0){
                    area.add(new int[] {y, x});
                } else if (map[y][x] == 2){
                    virus.add(new int[] {y, x});
                }
            }
        }

        aN = area.size();
        vN = virus.size();
        visited = new boolean[area.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int now, int depth){
        if (depth == 3){
            answer = Math.max(getCount(), answer);
            return;
        }

        for (int i=now; i<aN; i++){
            if (!visited[i]){
                visited[i] = true;
                int[] pos = area.get(i);
                map[pos[0]][pos[1]] = 1;

                dfs(i, depth+1);

                map[pos[0]][pos[1]] = 0;
                visited[i] = false;
            }
        }
    }

    static int getCount(){
        int[][] temp = new int[N][M];
        for (int i=0; i<N; i++){
            System.arraycopy(map[i], 0, temp[i], 0, M);
        }

        Queue<int[]> que = new LinkedList<>();
        for (int i=0; i<vN; i++){
            que.add(virus.get(i));
        }

        int[] dy = {-1, 0, +1, 0};
        int[] dx = {0, +1, 0, -1};

        while(!que.isEmpty()){
            int[] now = que.poll();

            for (int i=0; i<4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (temp[ny][nx] == 1 || temp[ny][nx] == 2) continue;

                temp[ny][nx] = 2;
                que.add(new int[] {ny, nx});
            }
        }

        int cnt = 0;
        for (int y=0; y<N; y++){
            for (int x=0; x<M; x++){
                if (temp[y][x] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
