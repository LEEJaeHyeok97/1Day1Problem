import java.util.Scanner;
public class Main {
    static final int INT_MIN = Integer.MIN_VALUE;
    static final int MAX_NUM = 50;

    static int n, m;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] dp = new int[MAX_NUM][MAX_NUM];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        initialize();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        if(dp[k][l] == INT_MIN) continue;

                        if(grid[k][l] < grid[i][j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }
            }
        }

        int ans = INT_MIN;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    static void initialize() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = INT_MIN;
            }
        }

        dp[0][0] = 1;
    }
}