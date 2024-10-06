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

        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            Integer t = Integer.parseInt(st.nextToken());
            if(!map.containsKey(t)){
                map.put(t, s);
                list.add(t);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = list.size()-1;
             while(start <= end){
                int mid = (end + start) / 2;
                int now = list.get(mid);

                if(t <= now) end = mid - 1;
                else start = mid + 1;
            }

             sb.append(map.get(list.get(start))).append('\n');
        }

        System.out.println(sb);
    }
}
