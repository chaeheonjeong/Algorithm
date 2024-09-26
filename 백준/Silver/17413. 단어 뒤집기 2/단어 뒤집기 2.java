import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static char[] s;
    static int p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();

        p = 0;
        Stack<Character> stack = new Stack<>();
        while(p < s.length){
            if(s[p] == '<' || s[p] == ' '){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }

                if(s[p] == '<') {
                    printPar();
                } else if(s[p] == ' '){
                    System.out.print(s[p++]);
                }
            } else{
                stack.push(s[p++]);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void printPar(){
        while(s[p] != '>'){
            System.out.print(s[p++]);
        }

        System.out.print(s[p++]);
    }
}
