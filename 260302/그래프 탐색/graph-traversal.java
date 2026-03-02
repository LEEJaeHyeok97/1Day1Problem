import java.util.Scanner;
public class Main {

    static int n, m;
    static int cnt = 0;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        graph = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt() - 1;

            graph[u[i]][v[i]] = 1;
            graph[v[i]][u[i]] = 1;
            // System.out.println(u[i] + " " + v[i]);
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.printf(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        visited[0] = true;
        dfs(0);
        
        System.out.println(cnt);
    }

    static void dfs(int curV) {
        for(int i = 0; i < n; i++) {
            if(graph[i][curV] == 1 && !visited[i]) {
                // System.out.println("visited");
                // for(int j = 0; j < n; j++) {
                //     System.out.printf(visited[j] + " ");
                // }
                // System.out.println();
                // System.out.println(i + " " + curV);
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }
}