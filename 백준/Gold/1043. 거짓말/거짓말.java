import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        people = new int[n+1];
        for(int i=1; i<n+1; i++){
            people[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if(cnt == 0){
            System.out.println(m);
            return;
        }

        int[] know = new int[cnt];
        for(int i=0; i<cnt; i++){
            know[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] party = new ArrayList[m];
        for(int i=0; i<m; i++){
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for(int j=0; j<c; j++){
                party[i].add(Integer.parseInt(st.nextToken()));
            }

            for(int j=1; j<c; j++){
                union(party[i].get(0), party[i].get(j));
            }
        }

        int answer = 0;
        for(int i=0; i<m; i++){
            boolean flag = false;
            int cur = party[i].get(0);
            for(int x: know){
                if(find(x) == find(cur)){
                    flag = true;
                    break;
                }
            }

            if(!flag) answer++;
        }

        System.out.println(answer);
    }

    public static void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);

        if(p1 != p2){
            people[p2] = p1;
        }
    }

    public static int find(int a){
        if(people[a] == a) return a;

        return people[a] = find(people[a]);
    }
}
