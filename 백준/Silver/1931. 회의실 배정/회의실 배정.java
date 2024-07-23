import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    static class MeetingComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] meeting = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new MeetingComparator());

        int count = 0;
        int end = -1;
        for(int i=0; i<n; i++){
            if(meeting[i][0] >= end){
                end = meeting[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
