import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[101];
        visited = new int[101];

        int n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        Arrays.fill(visited, Integer.MAX_VALUE);

        bfs();

        System.out.println(visited[100]);
    }

    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {1, 0});

        while(!que.isEmpty()){
            int[] now = que.poll();

            for(int i=1; i<=6; i++){
                int next = now[0] + i;
                int num = now[1] + 1;

                if(next > 100) continue;

                if(next == 100){
                    visited[100] = Math.min(visited[100], num);
                } else{
                    if(map[next] != 0){
                        next = map[next];
                    }
                    if(visited[next] > num) {
                        visited[next] = num;
                        que.add(new int[] {next, num});
                    }
                }
            }
        }
    }
}
