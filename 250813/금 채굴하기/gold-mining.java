import java.util.*;
import java.io.*;

// N * N 금을 최대한 많이 채굴
// 채굴은 마름모 모양으로 단 한번만 가능
// 마름모 모양을 지킨다면 그래프 영역을 벗어난 곳도 채굴 가능(단, 금은 없음)
// K = 0 은 지점 한 곳만 채굴하는 것을 의미
// 채굴 비용은 격자 갯수만큼 들어간다. K^2 + (K + 1)^2
// 금 한개의 가격 = M 손해보지 않으면서 가장 많은 금의 개수를 출력하는 코드를 작성.
// 한개의 격자 안에는 하나의 금만 들어있다.

public class Main {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    static int[][] graph;
    static int N;
    static int M;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, mineGold(i, j));
            }
        }

        System.out.println(ans);
    }

    static int mineGold(int x, int y) {
        Deque<Point> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        dq.add(new Point(x, y));
        visited[x][y] = true;

        int gold = 0;
        if (graph[x][y] == 1) {
            gold += 1;
        }
        int best = 0;

        int cost0 = 0 + (0 + 1) * (0 + 1);
        if (M * gold >= cost0) {
            best = Math.max(best, gold);
        }

        // 시뮬레이션 구현
        for (int i = 1; i < 2 * N; i++) {
            Deque<Point> next = new ArrayDeque<>();
            while (!dq.isEmpty()) {
                Point point = dq.poll();
                x = point.x;
                y = point.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];


                    if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        next.add(new Point(nx, ny));
                        if (graph[nx][ny] == 1) gold++;
                    }
                }
            }

            int cost = i * i + (i + 1) * (i + 1);
            if (M * gold >= cost) {
                best = Math.max(best, gold);
            }

            dq = next;
        }

        return best;
    }
}
