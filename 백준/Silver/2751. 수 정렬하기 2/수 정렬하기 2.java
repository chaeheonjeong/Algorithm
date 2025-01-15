import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: set){
            pq.add(x);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
