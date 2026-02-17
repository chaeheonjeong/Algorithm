import java.util.*;
import java.io.*;

public class Main {
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        long answer = 0;
        for (int i=0; i<N; i++){
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && h >= stack.peek()[1]){
                int[] now = stack.pop();
                answer += (i - now[0] - 1);
            }
            stack.push(new int[] {i, h});
        }

        while (!stack.isEmpty()){
            int[] now = stack.pop();
            answer += (N - now[0] - 1);
        }

        System.out.println(answer);
    }
}
