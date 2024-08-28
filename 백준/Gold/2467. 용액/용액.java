import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp >= 0){
                plus.add(tmp);
            } else {
                minus.add(tmp);
            }
        }

        if(plus.isEmpty()){
            System.out.println(minus.get(minus.size()-2) + " " + minus.get(minus.size()-1));
            return;
        } else if(minus.isEmpty()){
            System.out.println(plus.get(0) + " " + plus.get(1));
            return;
        }

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        if(plus.size() > 1){
            int a = plus.get(0);
            int b = plus.get(1);
            if(min > a+b){
                min = a+b;
                answer[0] = a;
                answer[1] = b;
            }
        }
        if(minus.size() > 1){
            int a = minus.get(minus.size()-2);
            int b = minus.get(minus.size()-1);
            if(min >= Math.abs(a+b)){
                min = Math.abs(a+b);
                answer[0] = a;
                answer[1] = b;
            }
        }

        int size1 = plus.size();
        int size2 = minus.size();
        int p1 = size1-1, p2 = 0;
        while(p1 >= 0 && p2 < size2){
            if (min > Math.abs(plus.get(p1) + minus.get(p2))) {
                min = Math.abs(plus.get(p1) + minus.get(p2));
                answer[0] = minus.get(p2);
                answer[1] = plus.get(p1);
            }

            if(plus.get(p1) >= (minus.get(p2) * -1)){
                p1--;
            } else {
                p2++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
