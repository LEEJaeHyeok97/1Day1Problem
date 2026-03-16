import java.util.*;

// n * n 격자 0, 1, 2로만 이루어짐.
// K개의 상한 귤 인접 4방향 1초에 한 번씩 모든 인접 귤이 상함
// 0 아무것도 없음, 1 귤, 2 상한 귤
// 처음 비어 있던 칸이면 -1을 출력, 처음 귤이 들어 있던 칸은 상하는데 까지 걸린 시간을 출력
// 끝까지 상하지 않은 귤이라면 -2를 출력
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, k;
    static int[][] grid;
    static int[][] step;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        step = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    step[i][j] = 0;
                }
                
                if(grid[i][j] == 0) step[i][j] = -1;
            }

        bfs();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(step[i][j] == 0 && grid[i][j] == 1) {
                    System.out.print(-2 + " ");
                } else {
                    System.out.print(step[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    static void bfs() {

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            visited[x][y] = true;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // System.out.println(nx + " " + ny);
                if(canGo(nx, ny)) {
                    // System.out.println(nx + " " + ny);
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    step[nx][ny] = step[x][y] + 1;
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    static boolean canGo(int x, int y) {
            if(!inRange(x, y)) return false;
            if(visited[x][y]) return false;
            if(grid[x][y] == 0 || grid[x][y] == 2) return false;
            return true;
        }
}