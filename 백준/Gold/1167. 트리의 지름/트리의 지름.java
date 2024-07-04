import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        distance = new int[n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int w = Integer.parseInt(st.nextToken());

                list[s].add(new Node(e, w));
            }
        }

        bfs(1);
        int max = Integer.MIN_VALUE;
        int idx = 1;
        for(int i=2; i<=n; i++){
            if(distance[i] > max){
                max = distance[i];
                idx = i;
            }
        }

        Arrays.fill(distance, 0);
        Arrays.fill(visited, false);
        bfs(idx);
        max = Integer.MIN_VALUE;
        for(int v: distance){
            max = Math.max(max, v);
        }

        System.out.println(max);
    }

    public static void bfs(int index){
        Queue<Integer> que = new LinkedList<>();
        que.add(index);
        visited[index] = true;

        while(!que.isEmpty()){
            int now_node = que.poll();
            for(Node i : list[now_node]){
                int end = i.end;
                int weight = i.weight;
                if(!visited[end]){
                    visited[end] = true;
                    que.add(end);
                    distance[end] = distance[now_node] + weight;
                }
            }
        }
    }
}
