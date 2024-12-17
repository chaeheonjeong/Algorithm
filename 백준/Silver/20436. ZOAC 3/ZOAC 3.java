import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken();
        String right = st.nextToken();
        String s = br.readLine();

        String[][] leftArr = {{"q", "w", "e", "r", "t"}, {"a", "s", "d", "f", "g"}, {"z", "x", "c", "v", "-1"}};
        String[][] rightArr = {{"-1", "y", "u", "i", "o", "p"}, {"-1", "h", "j", "k", "l", "-1"}, {"b", "n", "m", "-1", "-1", "-1"}};

        int ry = 0, rx = 0, ly = 0, lx = 0;
        for(int y=0; y<3; y++){
            for(int x=0; x<5; x++){
                if(left.equals(leftArr[y][x])) {
                    ly = y;
                    lx = x;
                }
            }
        }

        for(int y=0; y<3; y++){
            for(int x=0; x<6; x++){
                if(right.equals(rightArr[y][x])) {
                    ry = y;
                    rx = x;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<s.length(); i++){
            String target = s.substring(i, i+1);

            for(int y=0; y<3; y++){
                for(int x=0; x<5; x++){
                    if(target.equals(leftArr[y][x])){
                        answer += Math.abs(y - ly) + Math.abs(x - lx);
                        answer += 1;

                        ly = y;
                        lx = x;
                    }
                }
            }

            for(int y=0; y<3; y++){
                for(int x=0; x<6; x++){
                    if(target.equals(rightArr[y][x])){
                        answer += Math.abs(y - ry) + Math.abs(x - rx);
                        answer += 1;

                        ry = y;
                        rx = x;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
