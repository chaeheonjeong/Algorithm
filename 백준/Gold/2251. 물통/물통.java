import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static boolean[][] visited;
    static int[] bottle;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bottle = new int[3];
        int[] temp = new int[3];
        bottle[0] = sc.nextInt();
        bottle[1] = sc.nextInt();
        bottle[2] = sc.nextInt();
        temp[2] = bottle[2];
        visited = new boolean[bottle[0] + 1][bottle[1] +1];

        answer = new ArrayList<>();
        visited[0][0] = true;
        dfs(temp);

        System.out.println(answer.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }

    static void dfs(int[] now){
        if (now[0] == 0) {
            answer.add(now[2]);
        }

        for (int i = 0; i < 3; i++) {
            if (now[i] == 0) continue;
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    int temp1 = now[i];
                    int temp2 = now[j];

                    now[j] += now[i];
                    if(now[j] > bottle[j]) {
                        int x = now[j] - bottle[j];
                        now[j] = bottle[j];
                        now[i] = x;
                    } else {
                        now[i] = 0;
                    }

                    if(!visited[now[0]][now[1]]) {
                        visited[now[0]][now[1]] = true;
                        dfs(now);
                    }

                    now[i] = temp1;
                    now[j] = temp2;
                }
            }
        }
    }
}
