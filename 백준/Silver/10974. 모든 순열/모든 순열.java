import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];

            dfs(i, String.valueOf(i), 1);
        }
    }

    public static void dfs(int x, String s, int depth){
        visited[x] = true;

        if(depth >= n) {
            System.out.println(s);
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                dfs(i, s + " " + i,depth+1);
                visited[i] = false;
            }
        }
    }
}
