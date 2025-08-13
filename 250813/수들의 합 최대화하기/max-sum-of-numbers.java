import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[][] graph;
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        dfs(0);
        System.out.println(maxValue);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
//                System.out.print(arr.get(i) + " ");
                tmp += arr.get(i);
            }
            maxValue = Math.max(maxValue, tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
//            System.out.println(arr);
//            for (int a = 0; a < N; a++) {
//                for (int b = 0; b < N; b++) {
//                    System.out.print(graph[a][b] + " ");
//                }
//                System.out.println();
//            }
            arr.add(graph[cnt][i]);

            dfs(cnt + 1);
            visited[i] = false;
            arr.remove(arr.size() - 1);
        }
    }
}
