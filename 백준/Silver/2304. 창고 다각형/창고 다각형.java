import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][2];

        int maxL = -1;
        int maxH = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());

            if(a[i][1] > maxH){
                maxH = a[i][1];
                maxL = a[i][0];
            }
        }

        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        int answer = 0;

        int p = 0;
        int h = 0;
        for(int i=0; i<=maxL; i++){
            if(i == a[p][0]){
                h = Math.max(h, a[p][1]);
                p++;
            }
            answer += h;
        }

        p = n-1;
        h = 0;
        for(int i=a[n-1][0]; i>=maxL; i--){
            if(i == a[p][0]){
                h = Math.max(h, a[p][1]);
                p--;
            }
            answer += h;
        }

        answer -= maxH;

        System.out.println(answer);
    }
}
