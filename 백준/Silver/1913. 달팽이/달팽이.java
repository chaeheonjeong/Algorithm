import java.util.Scanner;

public class Main {
    static int cnt = 2;
    static int k;
    static int n;
    static int[][] map;
    static int x;
    static int y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        map = new int[n][n];
        x = n / 2;
        y = n / 2;
        map[y][x] = 1;

        for(int i=1; i<=n-1; i++){
            if(i % 2 != 0){
                yMinus(i);
                xPlus(i);
            } else{
                yPlus(i);
                xMinus(i);
            }
        }

        yMinus(n-1);

        int answerY = 0;
        int answerX = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");

                if(map[i][j] == k){
                    answerY = i+1;
                    answerX = j+1;
                }
            }
            System.out.println();
        }

        System.out.println(answerY + " " + answerX);
    }

    public static void xPlus(int t){
        for(int i=0; i<t; i++){
            map[y][++x] = cnt++;
        }
    }

    public static void xMinus(int t){
        for(int i=0; i<t; i++){
            map[y][--x] = cnt++;
        }
    }

    public static void yPlus(int t){
        for(int i=0; i<t; i++){
            map[++y][x] = cnt++;
        }
    }

    public static void yMinus(int t){
        for(int i=0; i<t; i++){
            map[--y][x] = cnt++;
        }
    }
}
