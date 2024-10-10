import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++){
            dq.add(i);
        }

        while(dq.size() != 1){
            dq.pollFirst();

            int t = dq.pollFirst();
            dq.addLast(t);
        }

        System.out.println(dq.poll());
    }
}
