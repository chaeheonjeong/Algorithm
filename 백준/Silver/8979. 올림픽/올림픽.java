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
        int k = Integer.parseInt(st.nextToken());

        int[][] countries = new int[n][4];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<4; j++){
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(countries, (a, b) -> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {
                    return b[3] - a[3];
                }
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });

        int cnt = 0;
        int rank = 0;
        int gold = -1, silver = -1, bronze = -1;
        for(int i=0; i<n; i++){
            if(gold != countries[i][1] || silver != countries[i][2] || bronze != countries[i][3]){
                gold = countries[i][1];
                silver = countries[i][2];
                bronze = countries[i][3];

                rank += cnt + 1;
                cnt = 0;
            } else{
                cnt++;
            }

            if(countries[i][0] == k) break;
        }

        System.out.println(rank);
    }
}
