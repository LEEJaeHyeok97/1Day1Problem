import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int[][] tmpGrid = new int[n][n];
                tmpGrid = bomb(i, j);
                // System.out.println("==========");
                // for(int a = 0; a < n; a++) {
                //     for(int b = 0; b < n; b++) {
                //         System.out.print(tmpGrid[a][b] + " ");
                //     }
                //     System.out.println();
                // }
                tmpGrid = gravity(tmpGrid);
                // System.out.println("==========");
                // for(int a = 0; a < n; a++) {
                //     for(int b = 0; b < n; b++) {
                //         System.out.print(tmpGrid[a][b] + " ");
                //     }
                //     System.out.println();
                // }
                int cnt = countDouble(tmpGrid);
                // System.out.println("==========");
                // System.out.println(cnt);
                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);
    }

    static int[][] bomb(int row, int col) {
        int[][] tmpGrid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                tmpGrid[i][j] = grid[i][j];
            }
        }

        int power = tmpGrid[row][col];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        tmpGrid[row][col] = 0;
        for(int i = 0; i < power - 1; i++) {
            for(int j = 0; j < 4; j++) {
                int nx = row + dx[j];
                int ny = col + dy[j];
                if(inRange(nx, ny)) {
                    tmpGrid[nx][ny] = 0;
                }
            }
        }

        return tmpGrid;
    }

    static int[][] gravity(int[][] tmpGrid) {
        for(int j = 0; j < n; j++) {
            int[] tmp = new int[n];
            int idx = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(tmpGrid[i][j] != 0) {
                    tmp[idx++] = tmpGrid[i][j];
                }
            }

            idx = 0;
            for(int k = n - 1; k >= 0; k--) {
                tmpGrid[k][j] = tmp[idx++];
            }
        }

        return tmpGrid;
    }

    static int countDouble(int[][] tmpGrid) {
        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(tmpGrid[i][j] == 0) continue;
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(inRange(x, y)) {
                        if(tmpGrid[i][j] == tmpGrid[x][y]) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt / 2;
    }

    static boolean inRange(int i, int j) {
        if((0 <= i && i < n) && (0 <= j && j < n)) return true;
        return false;
    }
}