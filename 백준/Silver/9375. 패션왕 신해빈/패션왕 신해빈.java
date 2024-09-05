import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int testcase = 0; testcase < t; testcase++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Map<String, Integer> closet = new HashMap<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();

                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(Integer count: closet.values()){
                answer *= (count+1);
            }

            System.out.println(answer - 1);
        }
    }
}
