import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] comb;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        comb = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            comb[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            comb[a].add(b);
            comb[b].add(a);
        }

        dfs(0, 1, new Stack<>());

        System.out.println(answer);
    }

    public static void dfs(int depth, int now, Stack<Integer> stack){
        if(depth == 3){
            answer++;
            return;
        }

        for(int i=now; i<=n; i++){
            if(!hasBad(stack, i)){
                stack.push(i);
                dfs(depth+1, i+1, stack);
                stack.pop();
            }
        }
    }

    public static boolean hasBad(Stack<Integer> stack, int target){
        for(int i=0; i<stack.size(); i++){
            if(comb[stack.get(i)].contains(target)) return true;
        }

        return false;
    }
}
