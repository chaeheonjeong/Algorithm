import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(pq.poll());

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int[] last = stack.peek();

            if (last[1] <= now[0]){
                stack.push(now);
            } else if (last[1] > now[1]){
                stack.pop();
                stack.push(now);
            }
        }

        System.out.println(stack.size());
    }
}
