import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n, m, k, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // grid 가로세로
        m = sc.nextInt(); // 폭발 최소 갯수
        k = sc.nextInt(); // 과정을 k번 반복
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        
        ans = 0;
        for(int i = 0; i < k; i++) {
            // bomb();
            while(bomb()) {
            gravity();
            }
            rotate();
            while(bomb()) {
            gravity();
            }
            // gravity();
        }

        //최종적으로 상자에 남아있는 폭타의 수를 출력
        countBomb();

        System.out.println(ans);
    }

    static boolean bomb() {
        boolean flag = false;

        for(int j = 0; j < n; j++) {
            int cnt = 0;
            int prev = 0;
            int end = -1;
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == 0) {
                    if(cnt >= m) {
                        for (int r = end; r >= end - cnt + 1; r--) {
                            if (grid[r][j] != 0) {
                                grid[r][j] = 0;
                                flag = true;
                            }
                        }
                    }
                    cnt = 0;
                    prev = 0;
                    end = -1;
                    continue;
                }

                if (cnt == 0) {
                prev = grid[i][j];
                cnt = 1;
                end = i;
                continue;
                }
    
                if(prev == grid[i][j]) {
                    cnt++;
                    end = i;
                } 
                else {
                    if(cnt >= m) {
                        // 폭발
                        for(int k = end; k >= end - cnt + 1; k--) {
                            if(grid[k][j] != 0) {
                                grid[k][j] = 0;
                                flag = true;
                            }
                        }
                    }
                    prev = grid[i][j];
                    cnt = 1;
                end = i;
                }

                // prev = grid[i][j];
                // end = i - 1;
            }
            if(cnt >= m) {
                for(int i = end; i >= end - cnt + 1; i--) {
                    if(grid[i][j] != 0) {
                        grid[i][j] = 0;
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    static void rotate() {
        int[][] newGrid = new int[n][n];
        for(int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for(int j = 0; j < n; j++) {
                tmp[j] = grid[i][j];
            }

            for(int j = 0; j < n; j++) {
                newGrid[j][n-i-1] = tmp[j];
            }
        }

        grid = newGrid;
    }

    static void gravity() {
        for(int j = 0; j < n; j++) {
            int[] tmp = new int[n];
            int idx = 0;
            for(int i = n - 1; i >= 0; i--) {
                if(grid[i][j] != 0) {
                    tmp[idx++] = grid[i][j];
                }
            }

            idx = 0;
            for(int k = n - 1; k >= 0; k--) {
                grid[k][j] = tmp[idx++];
            }
        }
    }

    static void countBomb() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) ans++;
            }
        }
    }
}