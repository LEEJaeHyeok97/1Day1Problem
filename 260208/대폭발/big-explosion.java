import java.util.Scanner;

// 격자 크기 n * n
// 시간 m
// 초기 폭탄 위치 r, c
public class Main {

    static int n, m, r, c;
    static int[][] grid;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        grid = new int[n][n];
        grid[r][c] = 1;
        int curT = 2;
        for(int idx = 0; idx < m; idx++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] <= curT - 1 && grid[i][j] > 0) {
                        for(int i2 = 0; i2 < 4; i2++) {
                            int nx = i + dx[i2] * (idx+1);
                            int ny = j + dy[i2] * (idx+1);
                            if(inRange(nx, ny)) {
                                if(grid[nx][ny] == 0) {
                                    grid[nx][ny] = curT;
                                }
                            }
                        }
                    }
                }
            }

            curT++;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean inRange(int r, int c) {
        if((0 <= r && r < n) && (0 <= c && c < n)) return true;
        return false;
    }
}