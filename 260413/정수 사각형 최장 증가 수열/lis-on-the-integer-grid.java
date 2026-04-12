import java.util.Scanner;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited = new boolean[n][n];
                visited[i][j] = true;
                dfs(i, j, 1);
            }
        }
        
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int tmp) {
        cnt = Math.max(cnt, tmp);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny, grid[x][y]) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, tmp + 1);
                visited[nx][ny] = false;
            }
        }
    }

    static boolean canGo(int x, int y, int prev) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] <= prev) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }
}