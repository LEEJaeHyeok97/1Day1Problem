import java.util.*;
import java.io.*;

// 1번 지점에서 시작해서 모든 지점을 정확히 1번만 방문하고 다시 1번으로 돌아오려고 한다.
// i->j 이동하는 비용이 Aij로 주어졌을 때
// 모든 정점을 겹치지 않고 방문하고 되돌아오는 데 필요한 최소 비용의 합을 구하시오.
// '1번 지점에서 출발'
public class Main {

    static int N;
    static boolean[] visited;
    static int ans;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        arr.add(0);
        ans = Integer.MAX_VALUE;
        dfs(1);

        System.out.println(ans);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            int totalCost = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                int currentCost = graph[arr.get(i)][arr.get(i + 1)];

                if (currentCost == 0) {
                    return;
                }

                totalCost += currentCost;
            }

            int lastPos = arr.get(arr.size() - 1);
            int additionalCost = graph[lastPos][0];
            if (additionalCost == 0) {
                return;
            }

            ans = Math.min(ans, totalCost + additionalCost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr.add(i);

            dfs(cnt + 1);

            visited[i] = false;
            arr.remove(arr.size() - 1);
        }


    }
}
