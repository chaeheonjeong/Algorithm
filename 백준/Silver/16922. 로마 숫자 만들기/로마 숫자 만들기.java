import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int answer;
    static boolean[] checkArr;
    static int[] arr = {1, 5, 10, 50};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        answer = 0;
        checkArr = new boolean[1001];

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int sum, int depth, int start){
        if(depth == n){
            if(!checkArr[sum]) {
                checkArr[sum] = true;
                answer++;
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            dfs(sum + arr[i], depth + 1, i);
        }
    }
}
