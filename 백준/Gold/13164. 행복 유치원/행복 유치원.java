import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] gap = new Integer[n-1];
        for(int i=0; i<n-1; i++){
            gap[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(gap, Collections.reverseOrder());

        int answer = 0;
        for(int i=k-1; i<n-1; i++){
            answer += gap[i];
        }

        System.out.println(answer);
    }
}
