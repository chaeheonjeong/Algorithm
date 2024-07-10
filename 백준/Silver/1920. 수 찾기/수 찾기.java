import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
            int target = b[i];
            int start = 0;
            int end = n - 1;
            boolean flag = false;
            while(start <= end){
                int mid = (start + end) / 2;
                if(target > a[mid]){
                    start = mid+1;
                } else if(target < a[mid]){
                    end = mid-1;
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) System.out.println("1");
            else System.out.println("0");
        }
    }
}
