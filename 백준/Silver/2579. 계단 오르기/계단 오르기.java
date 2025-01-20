import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];

        for(int i=0; i<n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            System.out.println(stairs[0]);
            return;
        } else if(n == 2){
            System.out.println(stairs[0]+stairs[1]);
            return;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = stairs[0];
        dp[0][1] = stairs[0];

        dp[1][0] = stairs[1];
        dp[1][1] = stairs[0] + stairs[1];

        for(int i=2; i<n; i++){
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
            dp[i][1] = dp[i-1][0] + stairs[i];
        }

        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
