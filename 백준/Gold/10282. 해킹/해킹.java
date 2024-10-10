import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t=0; t<testcase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<int[]>[] A = new ArrayList[n+1];
            for(int i=1; i<n+1; i++){
                A[i] = new ArrayList<>();
            }

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                A[b].add(new int[] {a, s});
            }

            int[] distance = new int[n+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[c] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o-> o[1]));
            pq.add(new int[] {c, 0});

            while(!pq.isEmpty()){
                int[] now = pq.poll();
                int node = now[0];
                int dist = now[1];

                if(dist > distance[node]) continue;

                for(int[] x: A[node]){
                    if(dist + x[1] < distance[x[0]]){
                        pq.add(new int[] {x[0], dist + x[1]});
                        distance[x[0]] = dist + x[1];
                    }
                }
            }

            int max = 0;
            int cnt = 1;

            for(int i=1; i<n+1; i++){
                if(distance[i] != Integer.MAX_VALUE && i != c){
                    cnt++;
                    max = Math.max(max, distance[i]);
                }
            }

            System.out.println(cnt + " " + max);
        }

    }
}
