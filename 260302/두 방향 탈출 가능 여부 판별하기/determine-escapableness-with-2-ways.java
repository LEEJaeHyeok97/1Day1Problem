import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(0);
    }

    static void dfs(int x, int y) {
        for(int i = 0; i < 2; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                if(nx == n - 1 && ny == m - 1) {
                    System.out.println(1);
                    System.exit(0);
                }
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 0) return false;
        if(visited[x][y] == true) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < m)) return true;
        return false;
    }
}