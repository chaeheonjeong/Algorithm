import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }
        Arrays.sort(a);

        int budget = Integer.parseInt(br.readLine());

        if(sum < budget) {
            System.out.println(a[n-1]);
            return;
        }

        int p = n-1;
        int cnt = 0;
        int answer = Integer.MIN_VALUE;
        while(p >= 0){
            sum -= a[p--];
            cnt++;

            int sanghan = (budget - sum) / cnt;
            answer = Math.max(answer, sanghan);
        }

        System.out.println(answer);
    }
}