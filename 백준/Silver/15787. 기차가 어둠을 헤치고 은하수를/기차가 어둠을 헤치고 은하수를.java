import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] trains = new boolean[n+1][21];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(command == 1){
                int x = Integer.parseInt(st.nextToken());
                trains[num][x] = true;
            } else if(command == 2){
                int x = Integer.parseInt(st.nextToken());
                trains[num][x] = false;
            } else if(command == 3){
                trains[num][20] = false;

                for(int j=19; j>=1; j--){
                    if(trains[num][j]){
                        trains[num][j] = false;
                        trains[num][j+1] = true;
                    }
                }
            } else if(command == 4){
                trains[num][1] = false;

                for(int j=2; j<=20; j++){
                    if(trains[num][j]){
                        trains[num][j] = false;
                        trains[num][j-1] = true;
                    }
                }
            }
        }

        Set<ArrayList<Boolean>> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            ArrayList<Boolean> list = new ArrayList<>();
            for(boolean b: trains[i]){
                list.add(b);
            }

            set.add(list);
        }

        System.out.println(set.size());
    }
}
