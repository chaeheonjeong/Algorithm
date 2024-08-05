import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] answer = new int[1000];
        for(int r=0; r<n; r++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i=123; i<=987; i++){
                if(!isDiff(i)) continue;
                int strike = 0;
                int ball = 0;

                String s1 = String.valueOf(t);
                String s2 = String.valueOf(i);
                for(int j=0; j<3; j++){
                    if(s1.charAt(j) == s2.charAt(j)) strike++;
                    else if(s1.contains(String.valueOf(s2.charAt(j)))) ball++;
                }

                if(strike == s && ball == b) {
                    answer[i]++;
                }
            }
        }

        int count = 0;
        for(int i=123; i<=987; i++){
            if(answer[i] == n) count++;
        }

        System.out.println(count);
    }

    public static boolean isDiff(int num){
        String s = String.valueOf(num);
        if(s.contains("0")) return false;
        
        if(s.charAt(0) == s.charAt(1)) return false;
        else if(s.charAt(0) == s.charAt(2)) return false;
        else return s.charAt(1) != s.charAt(2);
    }
}
