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
        int x = r -1;
        int y = c - 1;
        int saved;
        int[] dx = {-1, -1, 1, 1};
        int[] dy = { 1, -1,-1, 1};
        int[] ms = {m1, m2, m3, m4};
        if(dir == 0) {
            //반시계방향
            int prev = grid[x][y];
            for(int d = 0; d < 4; d++) {
                for(int i = 0; i < ms[d]; i++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int tmp = grid[nx][ny];
                    grid[nx][ny] = prev;
                    prev = tmp;
                    x = nx; y = ny;
                }
            }
        } 
        else {
            int prev = grid[x][y];
            for(int d = 3; d >= 0; d--) {
                for(int i = 0; i < ms[d]; i++) {
                    int nx = x - dx[d];
                    int ny = y - dy[d];
                    int tmp = grid[nx][ny];
                    grid[nx][ny] = prev;
                    prev = tmp;
                    x = nx; y = ny;
                }
            }
        }
    }
}