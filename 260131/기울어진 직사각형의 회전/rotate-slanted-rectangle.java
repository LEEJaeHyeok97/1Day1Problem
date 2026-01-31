import java.util.Scanner;
public class Main {

    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();
        // Please write your code here.
        rotate(r, c, m1, m2, m3, m4, dir);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int r, int c, int m1, int m2, int m3, int m4, int dir) {
        int x = r - 1;
        int y = c - 1;
        int[] ms = {m1, m2, m3, m4};
        int[] dx = {-1, -1, 1, 1}; // ↗ ↖ ↙ ↘
        int[] dy = {1, -1, -1, 1};

        if(dir == 1) {
            // 시계 방향
            int tmp = grid[x][y];
            for(int i = 3; i >= 0; i--) {
                for(int j = 0; j < ms[i]; j++) {
                    x -= dx[i];
                    y -= dy[i];

                    int tmp2 = grid[x][y];
                    grid[x][y] = tmp;
                    tmp = tmp2;
                }
            }
        }
        else {
            // 반시계 방향
            int tmp = grid[x][y];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < ms[i]; j++) {
                    x += dx[i];
                    y += dy[i];
                    int tmp2 = grid[x][y];
                    grid[x][y] = tmp;
                    tmp = tmp2;
                }
            }
        }
    }
}