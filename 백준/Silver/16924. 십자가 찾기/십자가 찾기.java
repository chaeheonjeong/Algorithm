import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> answer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int y=0; y<n; y++){
            String s = br.readLine();

            for(int x=0; x<m; x++){
                map[y][x] = s.charAt(x);
            }
        }

        answer = new ArrayList<>();
        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(map[y][x] == '*') isCross(y, x);
            }
        }

        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(map[y][x] == '*' && !visited[y][x]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        for(int i=0; i<answer.size(); i++){
            for(int j=0; j<3; j++){
                sb.append(answer.get(i)[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void isCross(int y, int x){

        int a = 1;
        while(true) {
            int newY1 = y-a;
            int newY2 = y+a;
            int newX1 = x-a;
            int newX2 = x+a;

            if(newY1 < 0 || newY2 >= n || newX1 < 0 || newX2 >= m) break;
            if(map[newY1][x] == '*' && map[newY2][x] == '*' && map[y][newX1] == '*' && map[y][newX2] == '*'){
                answer.add(new int[] {y+1, x+1, a});
                visited[newY1][x] = true;
                visited[newY2][x] = true;
                visited[y][newX1] = true;
                visited[y][newX2] = true;
                a++;
            } else {
                break;
            }
        }

        if(a > 1) visited[y][x] = true;
    }
}
