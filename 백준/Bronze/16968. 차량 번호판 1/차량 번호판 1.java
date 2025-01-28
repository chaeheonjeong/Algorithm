import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        int answer = 1;
        if(array[0] == 'd') answer = 10;
        else answer = 26;

        for(int i=1; i<array.length; i++){
            if(array[i] == 'd'){
                if(array[i-1] == 'd') answer *= 9;
                else answer *= 10;
            } else{
                if(array[i-1] == 'c') answer *= 25;
                else answer *= 26;
            }
        }

        System.out.println(answer);
    }
}
