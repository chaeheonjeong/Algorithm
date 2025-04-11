import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] map;
    static List<int[]> home;
    static List<int[]> chicken;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                int t = Integer.parseInt(st.nextToken());
                if(t == 1) home.add(new int[] {y, x});
                if(t == 2) chicken.add(new int[]{y, x});
            }
        }

        dfs(0, new Stack<>());
        System.out.println(answer);
    }

    public static void dfs(int now, Stack<Integer> stack){
        if(!stack.isEmpty() && stack.size() <= m){
            answer = Math.min(answer, getChickenDistance(stack));
            if(stack.size() == m) return;
        }

        for(int i=now; i<chicken.size(); i++){
            stack.push(i);
            dfs(i+1, stack);
            stack.pop();
        }
    }

    public static int getChickenDistance(Stack<Integer> stack){
        int sum = 0;

        for(int[] h : home){
            int minDist = Integer.MAX_VALUE;
            for(int i=0; i<stack.size(); i++){
                int[] c = chicken.get(stack.get(i));
                minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
            }

            sum += minDist;
        }

        return sum;
    }
}
