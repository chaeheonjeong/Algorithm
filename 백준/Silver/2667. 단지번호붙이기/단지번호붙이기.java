import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static PriorityQueue<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int y=0; y<n; y++){
            for(int x=0; x<n; x++){
                if(map[y][x] == 1){
                    bfs(y, x);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");

        while(!answer.isEmpty()){
            sb.append(answer.poll() + "\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int y, int x){
        int[] dirY = {-1, 0, +1, 0};
        int[] dirX = {0, +1, 0, -1};

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {y, x});
        map[y][x] = 0;

        int cnt = 1;

        while(!que.isEmpty()){
            int[] now = que.poll();

            for(int i=0; i<4; i++){
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];

                if(newY < 0 || newY >= n || newX < 0 || newX >= n) continue;
                if(map[newY][newX] == 0) continue;

                map[newY][newX] = 0;
                que.add(new int[] {newY, newX});
                cnt++;
            }
        }

        answer.add(cnt);
    }
}
