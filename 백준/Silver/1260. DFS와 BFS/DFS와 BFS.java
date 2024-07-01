import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(list[i]);
        }

        dfs(start);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(start);
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        for(int x: list[start]){
            if(visited[x]) continue;

            dfs(x);
        }
    }

    public static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int s = que.poll();
            System.out.print(s + " ");

            for(int x: list[s]){
                if(!visited[x]) {
                    visited[x] = true;
                    que.add(x);
                }
            }
        }
    }
}
