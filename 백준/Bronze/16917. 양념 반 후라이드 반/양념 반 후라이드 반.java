import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 후라이드, 양념으로 주문할 때
        int result1 = a * x + b * y;

        // 반반으로 주문할 때
        int t = Math.min(x, y);
        int result2 = t * c * 2;
        result2 += (x - t) * a;
        result2 += (y - t) * b;

        // 모두 반반으로 주문할 때
        t = Math.max(x, y);
        int result3 = t * c * 2;

        System.out.println(Math.min(Math.min(result1, result2), result3));
    }
}
