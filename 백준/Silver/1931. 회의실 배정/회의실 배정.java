import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    int start;
    int finish;

    public Time(int start, int finish){
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Time other){
        int finishComparison = Integer.compare(this.finish, other.finish);
        if(finishComparison == 0){
            return Integer.compare(this.start, other.start);
        }

        return finishComparison;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] meetingRoom = new Time[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            meetingRoom[i] = new Time(start, finish);
        }

        Arrays.sort(meetingRoom);
        int target = meetingRoom[0].finish;
        int answer = 1;
        for(int i=1; i<n; i++){
            if(target <= meetingRoom[i].start){
                answer++;
                target = meetingRoom[i].finish;
            }
        }

        System.out.println(answer);
    }
}
