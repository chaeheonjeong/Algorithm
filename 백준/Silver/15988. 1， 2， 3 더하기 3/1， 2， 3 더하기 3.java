import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<1000001; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        for(int t=0; t<testcase; t++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
