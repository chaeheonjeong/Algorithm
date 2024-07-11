import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        int start = 1;
        int end = sum;
        int answer = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(isGood(mid)){
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGood(int mid){
        int sum = 0;
        int count = 1;
        for(int i=0; i<n; i++){
            sum += a[i];
            if(sum > mid){
                count++;
                sum = a[i];
            }
            if(count > m || a[i] > mid){
                return false;
            }
        }

        return true;
    }
}
