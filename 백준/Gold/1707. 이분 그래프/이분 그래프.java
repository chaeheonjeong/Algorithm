import java.util.*;

public class Main {
    static boolean[] color;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int test=0; test<t; test++){
            int v = sc.nextInt();
            int e = sc.nextInt();

            color = new boolean[v+1];
            visited = new boolean[v+1];

            arr = new ArrayList[v+1];
            for(int i=0; i<v+1; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i=0; i<e; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[a].add(b);
                arr[b].add(a);
            }

            boolean flag = false;
           for(int i=1; i<=v; i++){
               if(!bfs(i)){
                   flag = true;
                   break;
               }
           }

           if(flag) System.out.println("NO");
           else System.out.println("YES");
        }
    }

    public static boolean bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int node = que.poll();

            for(int x: arr[node]){
                if(visited[x] && color[x] == color[node]) return false;
                if(!visited[x]) {
                    visited[x] = true;
                    color[x] = !color[node];
                    que.add(x);
                }
            }
        }

        return true;
    }
}
