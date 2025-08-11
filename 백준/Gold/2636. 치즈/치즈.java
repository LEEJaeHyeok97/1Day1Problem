import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, graph[][], cheese;
    static int time = 0;
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    cheese+=1;
                }
            }
        }


        int result = 0;
        while (cheese != 0) {
            visited = new boolean[N][M];
            result = cheese;
            bfs();
            time++;
        }
        System.out.println(time);
        System.out.println(result);
    }

    static void bfs() {
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;
                        cheese -= 1;
                    } else if (graph[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                    }
                }

            }
        }
    }
}
