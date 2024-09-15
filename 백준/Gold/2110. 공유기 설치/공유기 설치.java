import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] house;
    static int c;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for(int i=0; i<n; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[n-1] - house[0];
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(isPossible(mid)){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static boolean isPossible(int distance){
        int count = 1;
        int last = house[0];

        for(int i=1; i<n; i++){
            if(house[i] - last >= distance){
                count++;
                last = house[i];

                if(count >= c) return true;
            }
        }

        return false;
    }
}
