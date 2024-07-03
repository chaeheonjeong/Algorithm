import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] mirro;
    static boolean[][] visited;
    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        mirro = new int[h+1][w+1];
        visited = new boolean[h+1][w+1];

        for(int y=1; y<=h; y++){
            String line = br.readLine();
            for(int x=1; x<=w; x++){
                mirro[y][x] = Integer.parseInt(line.substring(x-1, x));
            }
        }

        bfs();
        System.out.println(mirro[h][w]);
    }

    public static void bfs(){
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{1,1});
        visited[1][1] = true;

        while(!que.isEmpty()){
            int y = que.peek()[0];
            int x = que.peek()[1];
            que.poll();
            int count = mirro[y][x];

            for(int i=0; i<4; i++){
                int newY = y+dirY[i];
                int newX = x+dirX[i];

                if(newY < 0 || newY > h || newX < 0 || newX > w || visited[newY][newX]) continue;
                if(mirro[newY][newX] == 1){
                    que.add(new Integer[]{newY, newX});
                    visited[newY][newX] = true;
                    mirro[newY][newX] = count + 1;
                }
            }
        }
    }
}
