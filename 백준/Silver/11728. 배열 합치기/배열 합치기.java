import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] c = new int[a];
        int[] d = new int[b];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            d[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(true){
            if(c[p1] <= d[p2]){
                sb.append(c[p1] + " ");
                p1++;
            } else{
                sb.append(d[p2] + " ");
                p2++;
            }

            if(p1 >= a || p2 >= b) break;
        }

        if(p1 >= a){
            for(int i=p2; i<b; i++){
                sb.append(d[i] + " ");
            }
        } else {
            for(int i=p1; i<a; i++){
                sb.append(c[i] + " ");
            }
        }

        System.out.println(sb);
    }
}
