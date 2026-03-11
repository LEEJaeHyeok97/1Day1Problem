import java.util.*;

// n*m 그리드 좌상->우하
// 탈출가능한 경로 최단거리
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[][] grid;
    static int[][] step;

    static Deque<Pair> q = new ArrayDeque<>();
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        step = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        q.add(new Pair(0, 0));
        visited[0][0] = true;
        step[0][0] = 0;
        bfs();

        if(step[n-1][m-1] == 0) System.out.println(-1);
        else System.out.println(step[n-1][m-1]);
    }

    static void bfs() {

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        if(grid[x][y] == 0) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }

    static void push(int x, int y, int stp) {
        q.add(new Pair(x, y));
        step[x][y] = stp;
        visited[x][y] = true;
    }
}