import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            List<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            boolean flag = false;
            for(int j=0; j<list.size(); j++){
                String target = list.get(j).substring(0,1).toLowerCase();

                if(!map.containsKey(target)) {
                    map.put(target, 0);

                    printWords(list, j, 0);

                    flag = true;
                    break;
                }
            }

            if(!flag){
                for(int j=0; j<list.size(); j++){
                    String s = list.get(j);

                    for(int k=1; k<s.length(); k++){
                        String target = s.substring(k, k+1).toLowerCase();

                        if(!map.containsKey(target)) {
                            map.put(target, 0);
                            printWords(list, j, k);
                            flag = true;
                            break;
                        }
                    }

                    if(flag) break;
                }

                if(!flag){
                    printWords(list, -1, -1);
                }
            }
        }
    }

    public static void printWords(List<String> list, int wordIdx, int idx){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++){
            String s = list.get(i);

            if(i == wordIdx){
                for(int j=0; j<s.length(); j++){
                    if(j == idx){
                        sb.append("[").append(s.charAt(j)).append("]");
                    } else{
                        sb.append(s.charAt(j));
                    }
                }

                sb.append(" ");
            } else{
                sb.append(s).append(" ");
            }
        }

        System.out.println(sb);
    }
}
