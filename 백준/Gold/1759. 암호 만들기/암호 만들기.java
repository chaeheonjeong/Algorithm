import java.util.*;
import java.io.*;

public class Main {
    static int moN;
    static int zaN;
    static List<String> mo;
    static List<String> za;
    static int L;
    static boolean[] moV;
    static boolean[] zaV;
    static List<String> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
        mo = new ArrayList<>();
        za = new ArrayList<>();

        for (int i=0; i<C; i++){
            String s = st.nextToken();
            if (set.contains(s)){
                mo.add(s);
            } else {
                za.add(s);
            }
        }


        answer = new ArrayList<>();
        moN = 1;
        zaN = L - moN;
        while(true){
            moV = new boolean[mo.size()];
            zaV = new boolean[za.size()];

            dfs(0, "", 0);

            moN++;
            if (L - moN < 2) break;
            zaN = L - moN;
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for(String x: answer){
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs (int depth, String s, int now){
        if(depth == moN){
            dfs_2(0, s, 0);
            return;
        }

        for (int i=now; i<mo.size(); i++){
            if (!moV[i]){
                moV[i] = true;
                dfs(depth+1, s+mo.get(i), i+1);
                moV[i] = false;
            }
        }
    }

    static void dfs_2 (int depth, String s, int now){
        if (depth == zaN){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            answer.add(new String(temp));
            return;
        }

        for (int i=now; i<za.size(); i++){
            if(!zaV[i]){
                zaV[i] = true;
                dfs_2(depth+1, s+za.get(i), i+1);
                zaV[i] = false;
            }
        }
    }
}
