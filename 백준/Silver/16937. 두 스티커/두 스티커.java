import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] stickers;
    static List<int[]> comb;
    static int n, h, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        stickers = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
            stickers[i][2] = stickers[i][0] * stickers[i][1];
        }

        comb= new ArrayList<>();
        combination();

        int max = 0;
        for(int[] x: comb){
            if(isStick(stickers[x[0]], stickers[x[1]])){
                max = Math.max(max, stickers[x[0]][2] + stickers[x[1]][2]);
            }
        }

        System.out.println(max);
    }

    static void combination(){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                comb.add(new int[] {i, j});
            }
        }
    }

    static boolean isStick(int[] a, int[] b){
        int[][] rotateA = {{a[0], a[1]}, {a[1], a[0]}};
        int[][] rotateB = {{b[0], b[1]}, {b[1], b[0]}};

        for(int[] rA: rotateA) {
            for (int[] rB : rotateB) {
                int ah = rA[0], aw = rA[1];
                int bh = rB[0], bw = rB[1];

                if ((ah + bh <= h) && (Math.max(aw, bw) <= m)) return true;
                if ((aw + bw <= m) && (Math.max(ah, bh) <= h)) return true;
            }
        }
        return false;
    }
}
