import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 2;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 3;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4; i<=10000; i++){
            dp[i][1] = dp[i-1][1] + dp[i-2][2] + dp[i-3][3];
            dp[i][2] = dp[i-2][2] + dp[i-3][3];
            dp[i][3] = dp[i-3][3];
        }

        for(int testcase=0; testcase<t; testcase++){
            int n = sc.nextInt();
            System.out.println(dp[n][1]);
        }
    }
}
