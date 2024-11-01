import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] A = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            int count = 0;

            for(int j=0; j<n; j++){
                if(A[j][0] > A[i][0] && A[j][1] > A[i][1]) count++;
            }

            answer[i] = count;
        }

        for(int x: answer){
            System.out.print(x+1 + " ");
        }
    }
}
