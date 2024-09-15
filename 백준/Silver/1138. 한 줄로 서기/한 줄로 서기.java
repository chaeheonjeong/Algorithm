import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n);
        for(int i=n-1; i>=1; i--){
            int diff = n - i;

            if(diff > a[i]){
                ans.add(a[i], i);
            } else if(diff == a[i]){
                ans.add(i);
            }
        }

        ans.stream().forEach(val -> System.out.print(val + " "));
    }
}
