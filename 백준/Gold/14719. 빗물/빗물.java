import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] block;
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int[] list = new int[w];
        block = new boolean[h][w];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<w; i++){
            int count = list[i];
            for(int j=h-1; j>=0; j--){
                if(count > 0){
                    block[j][i] = true;
                    count--;
                }
            }
        }

        int answer = 0;
        for(int y=0; y<h; y++){
            for(int x=0; x<w; x++){
                if(block[y][x]) continue;
                else if(x >= 1 && block[y][x-1]){
                   answer += countWater(y, x);
                }
            }
        }

        System.out.println(answer);
    }

    public static int countWater(int y, int x){
        int count = 1;
        while(true){
            x++;
            if(x >= w) return 0;
            else if(block[y][x]) return count;
            else if(!block[y][x]) count++;
        }
    }
}
