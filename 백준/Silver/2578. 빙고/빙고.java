import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        bingo = new int[5][5];

        for(int y=0; y<5; y++){
            st = new StringTokenizer(br.readLine());

            for(int x=0; x<5; x++){
                bingo[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int[] index = check(Integer.parseInt(st.nextToken()));

                if(isBingo(index[0], index[1])){
                    System.out.println(5 * i + j + 1);
                    return;
                }
            }
        }
    }

    public static int[] check(int n){
        for(int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                if(bingo[y][x] == n) {
                    bingo[y][x] = 0;
                    return new int[] {y, x};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public static boolean isBingo(int y, int x){
        boolean flag = true;
        for(int i=0; i<5; i++){
            if(bingo[y][i] != 0){
                flag = false;
                break;
            }
        }
        if(flag) count++;

        flag = true;
        for(int i=0; i<5; i++){
            if(bingo[i][x] != 0){
                flag = false;
                break;
            }
        }
        if(flag) count++;

        if(y == x){
            flag = true;
            for(int i=0; i<5; i++){
                if(bingo[i][i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        if(y + x == 4){
            flag = true;
            for(int i=0; i<5; i++){
                if(bingo[i][4-i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        return count >= 3;
    }
}
