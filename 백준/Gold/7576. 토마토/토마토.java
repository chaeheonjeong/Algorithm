import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int[][] box;
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++){
                box[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int answer = Integer.MIN_VALUE;
        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(box[y][x] == 0){
                    System.out.println(-1);
                    return;
                }

                answer = Math.max(answer, box[y][x]);
            }
        }

        System.out.println(answer-1);
    }

    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(box[y][x] == 1) que.add(new int[] {y, x});
            }
        }

        while(!que.isEmpty()){
            int[] now = que.poll();

            for(int i=0; i<4; i++){
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];

                if(newY < 0 || newY >= n || newX < 0 || newX >= m) continue;
                if(box[newY][newX] != 0) continue;

                que.add(new int[] {newY, newX});
                box[newY][newX] = box[now[0]][now[1]] + 1;
            }
        }
    }
}
