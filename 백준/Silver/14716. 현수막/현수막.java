import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] graph;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(graph));

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j);
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int startX, int startY) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startX, startY});
        graph[startX][startY] = 0; // mark visited

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0]; int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(0 <= nx && nx < M && 0 <= ny && ny < N)) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    continue;
                }

                graph[nx][ny] = 0;
                stack.push(new int[]{nx, ny});
            }
        }
    }
}
