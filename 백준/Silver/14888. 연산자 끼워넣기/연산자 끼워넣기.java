import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static char[] op;
    static int n;
    static boolean[] visited;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        num = new int[n];
        op = new char[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i=0; i<4; i++){
            int temp = Integer.parseInt(st.nextToken());

            if(i==0 && temp != 0){
                for(int j=0; j<temp; j++) {
                    op[idx++] = '+';
                }
            }else if(i==1 && temp != 0){
                for(int j=0; j<temp; j++) {
                    op[idx++] = '-';
                }
            }else if(i==2 && temp != 0){
                for(int j=0; j<temp; j++) {
                    op[idx++] = '*';
                }
            }else if(i==3 && temp != 0){
                for(int j=0; j<temp; j++) {
                    op[idx++] = '/';
                }
            }
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        visited = new boolean[n-1];
        dfs(1, String.valueOf(num[0]));

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, String now){
        if(depth == n){
            String[] s = now.split(" ");

            int sum = Integer.parseInt(s[0]);
            for(int i=1; i<s.length; i+=2){
                if(s[i].equals("+")){
                    sum += Integer.parseInt(s[i+1]);
                } else if(s[i].equals("-")){
                    sum -= Integer.parseInt(s[i+1]);
                } else if(s[i].equals("*")){
                    sum *= Integer.parseInt(s[i+1]);
                } else if(s[i].equals("/")){
                    sum /= Integer.parseInt(s[i+1]);
                }
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        for(int i=0; i<op.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, now + " " + op[i] + " " + num[depth]);
                visited[i] = false;
            }
        }
    }
}
