import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static int n;
    static int k;
    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();

        cnt = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(arr[i] == 'P') hasHamburger(i);
        }

        System.out.println(cnt);
    }

    public static void hasHamburger(int idx){
        for(int i=idx-k; i<=idx+k; i++){
            if(i < 0 || i>= n) continue;

            if(arr[i] == 'H' && !visited[i]){
                visited[i] = true;
                cnt++;
                return;
            }
        }
    }
}
