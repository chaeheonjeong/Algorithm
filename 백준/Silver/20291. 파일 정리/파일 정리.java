import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = arr[i].indexOf(".");
            String extension = arr[i].substring(x + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i]).append(" ").append(map.get(keys[i])).append("\n");
        }

        System.out.println(sb);
    }
}
