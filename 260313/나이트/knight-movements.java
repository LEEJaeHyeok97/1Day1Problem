import java.util.*;

// 나이트는 8곳으로 움직임가능
//n * n 격자
// 나이트가 시작점에서 도착점까지 가는 데 걸리는 최소 이동 횟수
// (r1,c1) -> (r2,c2)
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int ans = 0;
    static int n, r1, c1, r2, c2;

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    static boolean[][] visited;
    static int[][] grid;
    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        grid = new int[n][n];
        visited = new boolean[n][n];

        q.add(new Pair(r1, c1));
        visited[r1][c1] = true;
        grid[r1][c1] = 0;
        bfs();

        if(visited[r2][c2]) System.out.println(grid[r2][c2]);
        else System.out.println(-1);
    }

    static void bfs() {

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    grid[nx][ny] = grid[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}