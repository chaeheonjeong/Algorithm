import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int y;
        int x;
        int num;
        int sum;

        public Node(int y, int x, int num, int sum){
            this.y = y;
            this.x = x;
            this.num = num;
            this.sum = sum;
        }
    }

    static int[][] map;
    static int n;
    static int m;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        bfs();

        System.out.println(min);
    }

    public static void bfs(){
        int[] dirY = {1, 1, 1};
        int[] dirX = {-1, 0, +1};

        Queue<Node> que = new LinkedList<>();

        for(int i=0; i<m; i++){
            que.add(new Node(0, i, -1, map[0][i]));
        }

        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.y == n-1) {
                min = Math.min(min, now.sum);
            }

            for(int i=0; i<3; i++){
                if(i == now.num) continue;

                int newY = now.y + dirY[i];
                int newX = now.x + dirX[i];

                if(newY < 0 || newY >= n || newX < 0 || newX >= m) continue;

                que.add(new Node(newY, newX, i, now.sum + map[newY][newX]));
            }
        }
    }
}
