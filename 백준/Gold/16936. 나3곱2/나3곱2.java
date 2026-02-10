import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean flag;
    static boolean[] visited;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new long[N];
        for (int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        visited = new boolean[N];
        Arrays.fill(visited, false);

        for (int i=0; i<N; i++) {
            visited[i] = true;
            dfs(i, new Stack<>());
            visited[i] = false;
        }
    }

    static void dfs(int now, Stack<Long> stack){
        stack.push(arr[now]);

        if (stack.size() >= N){
            flag = true;

            for (long x: stack){
                System.out.print(x + " ");
            }

            return;
        }

        for (int i=0; i<N; i++){
            if (!visited[i] && isGood(arr[now], arr[i])){
                visited[i] = true;
                dfs(i, stack);

                if (flag) break;

                visited[i] = false;
                stack.pop();
            }
        }
    }

    static boolean isGood(long a, long b){
        return ((a / 3 == b && a % 3 == 0) || a * 2 == b);
    }
}
