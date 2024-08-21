import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][][] map;
    static int[] dirY = {-1, 0, +1, 0};
    static int[] dirX = {0, +1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m][2];

        for(int y=0; y<n; y++){
            String s = sc.nextLine();
            for(int x=0; x<m; x++){
                map[y][x][0] = s.charAt(x) - '0';
            }
        }

        bfs();

        if(map[n-1][m-1][0] == 1) System.out.println(1);
        else if(map[n-1][m-1][1] == 0) System.out.println(-1);
        else if(map[n-1][m-1][0] == 0) System.out.println(map[n-1][m-1][1]);
        else System.out.println(Math.min(map[n-1][m-1][0], map[n-1][m-1][1]));

    }

    public static void bfs(){
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[] {0,0,0});
        map[0][0][0] = 1;

        while(!que.isEmpty()){
            Integer[] now = que.poll();

            for(int i=0; i<4; i++){
                int newY = now[0] + dirY[i];
                int newX = now[1] + dirX[i];

                if(newY < 0 || newY >= n || newX < 0 || newX >= m) continue;
                if(now[2] == 0){ // 벽을 부순 적이 없을 때
                    if(map[newY][newX][0] > 1) continue;
                    if(map[newY][newX][0] == 1){
                        map[newY][newX][1] = map[now[0]][now[1]][0] + 1;
                        que.add(new Integer[]{newY, newX, 1});
                    } else {
                        map[newY][newX][0] = map[now[0]][now[1]][0] + 1;
                        que.add(new Integer[]{newY, newX, 0});
                    }
                } else if(now[2] == 1){ // 벽을 부순 적이 있을 때
                    if(map[newY][newX][1] > 1) continue;
                    if(map[newY][newX][0] == 1) continue;
                    else{
                        map[newY][newX][1] = map[now[0]][now[1]][1] + 1;
                        que.add(new Integer[]{newY, newX, 1});
                    }
                }
            }
        }
    }
}
