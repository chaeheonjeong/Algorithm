import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            que.add(sc.nextInt());
        }

        int answer = 0;
        while(que.size() != 1){
            int a = que.poll();
            int b = que.poll();
            answer += (a + b);
            que.add(a+b);
        }

        System.out.println(answer);
    }
}
