import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] trees;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            trees[i] = a;
            max = Math.max(max, a);
        }

        int start = 0;
        int end = max;

        while(start <= end){
            int mid = (end + start) / 2;

            if(isOver(mid)){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(end);
    }

    public static boolean isOver(int len){
        long sum = 0;
        for(int i=0; i<n; i++){
            if(trees[i] - len > 0) {
                sum += trees[i] - len;
                if(sum >= m) return true;
            }
        }

        return false;
    }
}
