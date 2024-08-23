import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] table = new int[n];
        int[] sushi = new int[d + 1];

        for(int i=0; i<n; i++){
            table[i] = Integer.parseInt(br.readLine());
        }

        sushi[c]++;
        int answer = 1;
        for(int i=0; i<k; i++){
            if(sushi[table[i]] == 0) answer++;
            sushi[table[i]]++;
        }

        int start = 0;
        int end = k-1;
        int count = answer;
        while(true){
            sushi[table[start]]--;
            if(sushi[table[start]] == 0) count--;

            if(start == n-1) start = 0;
            else start++;

            if(end == n-1) end = 0;
            else end++;

            if(end == k-1) break;
            sushi[table[end]]++;

            if(sushi[table[end]] == 1) count++;

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
