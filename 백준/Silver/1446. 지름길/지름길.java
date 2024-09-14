import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int ap = Integer.parseInt(st.nextToken());

        List<int[]>[] A = new List[10000];
        for(int i=0; i<10000; i++){
            A[i] = new ArrayList<>();
        }

        List<Integer> node = new ArrayList<>();
        node.add(0);
        node.add(ap);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if(start > ap || end > ap) continue;

            if(!node.contains(start)){
                node.add(start);
            }
            if (!node.contains(end)) {
                node.add(end);
            }

            A[start].add(new int[]{end, length});
        }

        Collections.sort(node);

        for(int i=0; i<node.size()-1; i++){
            int now = node.get(i);
            int next = node.get(i+1);
            A[now].add(new int[]{next, next - now});
        }

        int[] distance = new int[10001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int now = poll[0];
            int dist = poll[1];

            if(dist > distance[now]) continue;

            for(int[] x: A[now]){
                if(x[1] + dist < distance[x[0]]){
                    pq.add(new int[] {x[0], x[1] + dist});
                    distance[x[0]] = x[1] + dist;
                }
            }
        }

        System.out.println(distance[ap]);
    }
}
