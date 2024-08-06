import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[][] ability;
    static int combinationNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        ability = new int[n][n];
        visited = new boolean[n];

        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++){
                ability[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n; i++){
            combinationNumber = i;
            count(0, 0);
        }

        System.out.println(min);
    }

    public static void count(int depth, int s){
        if(depth == combinationNumber){
            int link = 0;
            int start = 0;
            for(int y=0; y<n; y++){
                for(int x=0; x<n; x++){
                    if(visited[y] && visited[x]){
                        link += ability[y][x];
                    } else if(!visited[y] && !visited[x]){
                        start += ability[y][x];
                    }
                }
            }

            min = Math.min(min, Math.abs(link - start));
            return;
        }

        for(int i=s; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                count(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
