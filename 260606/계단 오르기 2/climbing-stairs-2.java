import java.util.Scanner;
public class Main {

    static int[][] dp;
    static int n;
    static int[] coins;
    static void initialize() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new int[n + 1];
        dp = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        initialize();
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 3; j++) {
                if(j - 1 >= 0 && dp[i-1][j-1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + coins[i] ,dp[i][j]);
                }
                if(i - 2 >= 0 && dp[i - 2][j] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 2][j] + coins[i], dp[i][j]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= 3; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}