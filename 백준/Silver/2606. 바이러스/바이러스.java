import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int cnt;
    static List<Integer>[] computer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        computer = new ArrayList[n + 1];
        for(int i=1; i<n+1; i++){
            computer[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a].add(b);
            computer[b].add(a);
        }

        visited = new boolean[n+1];
        cnt = 0;
        dfs(1);


        System.out.println(cnt);
    }

    public static void dfs(int now){
        visited[now] = true;

        for(int x: computer[now]){
            if(!visited[x]){
                cnt++;
                dfs(x);
            }
        }
    }
}
