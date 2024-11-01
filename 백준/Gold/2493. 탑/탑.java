import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && stack.peek()[0] < A[i]) {
                stack.pop();
            }

            if(stack.isEmpty()){
                answer[i] = 0;
                stack.push(new int[] {A[i], i+1});
            } else{
                answer[i] = stack.peek()[1];
                stack.push(new int[] {A[i], i+1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int x: answer){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
