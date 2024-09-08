import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] a = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            a[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        int[] selfBuild = new int[n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while(true){
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp == -1) break;
                a[preTemp].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        int[] result = new int[n+1];
        while(!que.isEmpty()){
            int now = que.poll();
            for(int x: a[now]){
                indegree[x]--;

                result[x] = Math.max(result[x], result[now] + selfBuild[now]);
                if(indegree[x] == 0){
                    que.offer(x);
                }
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
