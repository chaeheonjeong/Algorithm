import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int answer = 0;
        int p1 = 0, p2 = 0;

        count[a[p1]]++;
        while(true) {
            p2++;
            if(p2 >= n) break;
            count[a[p2]]++;

            while (count[a[p2]] > k) {
                count[a[p1]]--;
                p1++;
            }
            answer = Math.max(answer, p2 - p1 + 1);
        }

        System.out.println(answer);
    }
}
