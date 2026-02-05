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
            bomb();
            gravity();
            rotate();
            gravity();
        }

        //최종적으로 상자에 남아있는 폭타의 수를 출력
        bomb();
        countBomb();

        System.out.println(ans);
    }

    static void bomb() {
        int cnt;
        for(int j = 0; j < n; j++) {
            cnt = 1;
            int prev = grid[0][j];
            int end = 0;
            for(int i = 1; i < n; i++) {
                if(grid[i][j] == 0) {
                    if(cnt >= m) {
                        for(int k = i - 1; k >= i - cnt; k--) {
                            grid[k][j] = 0;
                        }
                    }
                    cnt = 1;
                    prev = Integer.MIN_VALUE;
                    end = i -1;
                    continue;
                }
                if(prev == grid[i][j]) {
                    cnt++;
                } 
                else {
                    if(cnt >= m) {
                        // 폭발
                        for(int k = end; k >= end - cnt + 1; k--) {
                            grid[k][j] = 0;
                        }
                    }
                    cnt = 1;
                    end = i - 1;
                }

                prev = grid[i][j];
                end = i - 1;
            }
            if(cnt >= m) {
                for(int i = end; i >= end - cnt + 1; i--) {
                    grid[i][j] = 0;
                }
            }
        }
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