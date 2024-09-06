import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info implements Comparable<Info>{
    int y;
    int x;
    int value;

    public Info(int y, int x, int value){
        this.y = y;
        this.x = x;
        this.value = value;
    }

    @Override
    public int compareTo(Info o){
        return Integer.compare(this.value, o.value);
    }
}

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static int[][] visited;
    static int n;
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            map = new int[n][n];
            visited = new int[n][n];
            init();
            dijkstra();

            StringBuilder sb = new StringBuilder().append("Problem ").append(t++).append(": ").append(visited[n - 1][n - 1]);
            System.out.println(sb);
        }
    }

    public static void init() throws IOException {
        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int[] x: visited){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        visited[0][0] = map[0][0];
    }

    public static void dijkstra(){
        PriorityQueue<Info> que = new PriorityQueue<>();
        que.offer(new Info(0, 0, map[0][0]));

        while(!que.isEmpty()){
            Info current = que.poll();

            if (current.value > visited[current.y][current.x]) continue;

            for(int i=0; i<4; i++){
                int newY = current.y + dirY[i];
                int newX = current.x + dirX[i];

                if (newY < 0 || newY >= n || newX < 0 || newX >= n) continue;

                int newCost = current.value + map[newY][newX];

                if(newCost < visited[newY][newX]){
                    visited[newY][newX] = newCost;
                    que.offer(new Info(newY, newX, newCost));
                }
            }
        }
    }
}
