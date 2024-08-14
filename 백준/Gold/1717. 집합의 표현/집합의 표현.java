import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new int[n+1];
        for(int i=0; i<=n; i++){
            set[i] = i;
        }

        int type = 0;
        int a = 0;
        int b = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(type == 0){
                if(a == b) continue;

                int r1 = findRep(a);
                int r2 = findRep(b);

                if(r1 == r2) continue;
                set[r2] = r1;
            } else {
                if(a == b) {
                    System.out.println("YES");
                } else {
                    int r1 = findRep(a);
                    int r2 = findRep(b);

                    if(r1 == r2) System.out.println("YES");
                    else System.out.println("NO");
                }
            }
        }
    }

    public static int findRep(int x){
        if(set[x] == x) return x;

        int rep = findRep(set[x]);
        set[x] = rep;
        return rep;
    }
}
