import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer> answer;
    public static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        dfs(1, 2);
        dfs(1, 3);
        dfs(1, 5);
        dfs(1, 7);

        Collections.sort(answer);
        for(int x: answer){
            System.out.println(x);
        }
    }

    public static void dfs(int t, int n){
        if(t == target){
            answer.add(n);
            return;
        }

        for(int i=1; i<=9; i++){
            if(!isPrime(10 * n + i)) continue;
            dfs(t+1, 10 * n + i);
        }
    }

    public static boolean isPrime(int n){
        for(int i=2; i<n/2; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
