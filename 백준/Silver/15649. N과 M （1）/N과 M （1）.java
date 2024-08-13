import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];

        dfs(0, new ArrayList<>());
    }

    public static void dfs(int depth, ArrayList<Integer> ans){
        if(depth == m){
            ans.stream().forEach(e -> System.out.print(e + " "));
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]) {
                visited[i] = true;
                ans.add(i);
                dfs(depth+1, ans);
                visited[i] = false;
                ans.remove(Integer.valueOf(i));
            }
        }
    }
}
