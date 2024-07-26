import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splitByMinus = line.split("-");
        int answer = getSum(splitByMinus[0]);

        if(splitByMinus.length == 1) {
            System.out.println(answer);
            return;
        }

        for(int i=1; i<splitByMinus.length; i++){
            answer -= getSum(splitByMinus[i]);
        }
        System.out.println(answer);
    }

    public static int getSum(String s){
        int sum = 0;
        String[] splitByPlus = s.split("\\+");
        for(int i=0; i<splitByPlus.length; i++){
            sum += Integer.parseInt(splitByPlus[i]);
        }

        return sum;
    }
}
