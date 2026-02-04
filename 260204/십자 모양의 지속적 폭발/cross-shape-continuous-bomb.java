import java.util.Scanner;
public class Main {

    static int n, m;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < m; i++) {
            int col = sc.nextInt();
            col -= 1;
            
            bomb(col);
            gravity();
        }
            
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bomb(int col) {
        int x = -1;
        int y = col;
        int range = -1;
        // 터질 행 탐색
        for(int i = 0; i < n; i++) {
            if(grid[i][col] != 0) {
                x = i;
                range = grid[i][col];
                break;
            }
        }

        // 폭발 시뮬레이션
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        range -= 1;
        if(range < 0) {
            return;
        }
        // 자기자신 폭발
        grid[x][y] = 0;
        
        int cnt = 1;
        while(range >= 1) {
            for(int i = 0; i < 4; i++) {
                int nx = 0, ny = 0;
                nx = x + dx[i] *cnt;
                ny = y + dy[i] *cnt;

                if(inRange(nx, ny)) {
                    grid[nx][ny] = 0;
                }
            }

            cnt++;
            range--;
        }
    }

    static void gravity() {
        for(int j = 0; j < n; j++) {
            int tmp = 0;
            for(int i = 0; i < n; i++){
                if(grid[i][j] != 0) {
                    tmp++;
                }
            }

            if(tmp == 0) {
                continue;
            }
            int[] arr = new int[tmp];
            tmp = 0;
            // System.out.print(arr.length);
            // System.out.println();
            for(int i = 0; i < n; i++) {
                if(grid[i][j] != 0) {
                    arr[tmp++] = grid[i][j];
                    grid[i][j] = 0;
                }
            }

            tmp = n - 1;
            for(int idx = arr.length - 1; idx >= 0; idx--) {
                grid[tmp--][j] = arr[idx];
            }
        }
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x <n) && (0 <= y && y < n)) return true;
        return false;
    }
}