import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] city;
    static ArrayList<Integer> answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        city = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            city[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            city[a].add(b);
        }

        answer = new ArrayList<>();
        visited = new boolean[n+1];
        bfs(k, x);

        if(answer.isEmpty()){
            System.out.println(-1);
        } else{
            Collections.sort(answer);
            for(int a: answer){
                System.out.println(a);
            }
        }
    }

    public static void bfs(int target, int start){
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{start, 0});
        visited[start] = true;

        while(!que.isEmpty()){
            Integer[] temp = que.poll();
            if(temp[1] == target){
                answer.add(temp[0]);
                continue;
            }

            for(int x: city[temp[0]]){
                if(visited[x]) continue;

                visited[x] = true;
                que.add(new Integer[]{x, temp[1]+1});
            }
        }
    }
}
