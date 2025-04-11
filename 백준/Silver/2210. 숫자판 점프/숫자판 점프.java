import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};
    static HashSet<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int y=0; y<5; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<5; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                dfs(y, x, 1, String.valueOf(map[y][x]));
            }
        }
        
        System.out.println(answer.size());
    }

    public static void dfs(int y, int x, int deps, String num){
        if(deps == 6){
            answer.add(num);
            return;
        }

        for(int i=0; i<4; i++){
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if(newY < 0 || newY >= 5 || newX < 0 || newX >= 5) continue;
            dfs(newY, newX, deps+1, num + map[newY][newX]);
        }
    }
}
