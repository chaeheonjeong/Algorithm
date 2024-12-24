import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(0,0,0,0,0,0, y, x);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int dir = Integer.parseInt(st.nextToken());

            int temp = dice.bottom;
            if(dir == 1){
                if(dice.curX + 1 >= m) continue;
                dice.curX++;

                dice.bottom = dice.right;
                dice.right = dice.top;
                dice.top = dice.left;
                dice.left = temp;

            } else if(dir == 2){
                if(dice.curX - 1 < 0) continue;
                dice.curX--;

                dice.bottom = dice.left;
                dice.left = dice.top;
                dice.top = dice.right;
                dice.right = temp;
            } else if(dir == 3){
                if(dice.curY - 1 < 0) continue;
                dice.curY--;

                dice.bottom = dice.back;
                dice.back = dice.top;
                dice.top = dice.front;
                dice.front = temp;
            } else{
                if(dice.curY + 1 >= n) continue;
                dice.curY++;

                dice.bottom = dice.front;
                dice.front = dice.top;
                dice.top = dice.back;
                dice.back = temp;
            }

            if(map[dice.curY][dice.curX] == 0){
                map[dice.curY][dice.curX] = dice.bottom;
            } else{
                dice.bottom = map[dice.curY][dice.curX];
                map[dice.curY][dice.curX] = 0;
            }

            System.out.println(dice.top);
        }
    }

    public static class Dice{
        int top, bottom;
        int right, left;
        int front, back;

        int curX, curY;

        public Dice(int top, int bottom, int right, int left, int front, int back, int curX, int curY){
            this.top = top;
            this.bottom = bottom;
            this.right = right;
            this.left = left;
            this.front = front;
            this.back = back;
            this.curX = curX;
            this.curY = curY;
        }
    }
}
