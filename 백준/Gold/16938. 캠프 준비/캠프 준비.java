import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int l;
    static int r;
    static int x;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0, new Stack<>());

        System.out.println(answer);
    }

    static void dfs(int now, long sum, Stack<Integer> stack){
        if(sum > r) return;
        if(sum >= l && sum <= r){
            if(stack.size() >= 2 && (stack.peek() - stack.get(0)) >= x) answer++;
        }

        for(int i=now; i<n; i++){
            stack.push(arr[i]);
            dfs(i+1, sum + arr[i], stack);
            stack.pop();
        }
    }
}