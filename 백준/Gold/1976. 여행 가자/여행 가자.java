import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] city;
    static boolean[] visited;
    static ArrayList<Integer>[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        cities = new ArrayList[n+1];
        city = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<n+1; i++){
            cities[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                int con = Integer.parseInt(st.nextToken());
                if(con == 1){
                    cities[i].add(j);
                }
            }
        }

        for(int i=1; i<n+1; i++){
            city[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int[] travel = new int[m];
        for(int i=0; i<m; i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                dfs(i, i);
            }
        }

        int rep = city[travel[0]];
        for(int x: travel){
            if(rep != city[x]){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void dfs(int rep, int now){
        visited[now] = true;
        city[now] = rep;

        for(int x: cities[now]){
            if(!visited[x]){
                visited[x] = true;
                dfs(rep, x);
            }
        }
    }
}
