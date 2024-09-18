import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static Stack<Character> stack;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        target = br.readLine();
        int answer = 0;
        for(int i=0; i<n-1; i++){
            stack = new Stack<>();
            initStack();

            String s = br.readLine();

            List<Character> list = new ArrayList<>();
            for(char x: s.toCharArray()){
                list.add(x);
            }

            int cnt = 0;
            while(!stack.isEmpty()){
                char c = stack.pop();

                boolean flag = false;
                for(int j=0; j<list.size(); j++){
                    if(list.get(j) == c){
                        list.remove(j);
                        flag = true;
                        break;
                    }
                }

                if(!flag) cnt++;
            }

            if(list.size() > 1 || cnt > 1) continue;

            answer++;
        }

        System.out.println(answer);
    }

    public static void initStack(){
        for(char x: target.toCharArray()){
            stack.push(x);
        }
    }
}
