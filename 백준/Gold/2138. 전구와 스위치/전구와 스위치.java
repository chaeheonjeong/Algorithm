import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        boolean[] a = new boolean[n];
        t = new boolean[n];


        String input = br.readLine();
        for(int i=0; i<n; i++){
            if(input.charAt(i) == '1') a[i] = true;
        }
        boolean[] b = Arrays.copyOf(a, a.length);

        input = br.readLine();
        for(int i=0; i<n; i++){
            if(input.charAt(i) == '1') t[i] = true;
        }

        change(a, 0);
        int answer = Math.min(getCount(a, 1), getCount(b, 0));

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static int getCount(boolean[] x, int count){
        for(int i=0; i<n-1; i++){
            if(x[i] != t[i]){
                change(x, i+1);
                count++;
            }
        }

        if(x[n-1] != t[n-1]){
            return Integer.MAX_VALUE;
        }

        return count;
    }

    public static void change(boolean[] x, int idx){
        if(idx == 0){
            x[0] = !x[0];
            x[1] = !x[1];
        } else if(idx == n-1){
            x[n-2] = !x[n-2];
            x[n-1] = !x[n-1];
        }
        else {
            x[idx-1] = !x[idx-1];
            x[idx] = !x[idx];
            x[idx+1] = !x[idx+1];
        }
    }
}
