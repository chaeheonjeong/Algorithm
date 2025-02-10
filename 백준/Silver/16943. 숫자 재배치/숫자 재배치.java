import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] arr;
    static boolean[] visited;
    static int b;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        b = Integer.parseInt(st.nextToken());
        max = -1;

        arr = new String[a.length()];
        for(int i=0; i<a.length(); i++){
            arr[i] = a.substring(i, i+1);
        }
        visited = new boolean[arr.length];

        for(int i=0; i<arr.length; i++){
            if("0".equals(arr[i])) continue;

            visited[i] = true;
            dfs(arr[i], 1);
            visited[i] = false;
        }

        System.out.println(max);
    }

    public static void dfs(String now, int depth){
        if(depth == arr.length && Integer.parseInt(now) < b){
            max = Math.max(max, Integer.parseInt(now));
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(now + arr[i], depth+1);
                visited[i] = false;
            }
        }
    }
}
