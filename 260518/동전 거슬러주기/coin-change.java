import java.util.Scanner;

public class Main {
    static int n, m;

    static int[] dp;
    static int[] coin;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[m + 1];
        coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();

        for(int i = 0; i < m + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coin[j] >= 0) {
                    if(dp[i - coin[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
                    }
                }
            }
        }

        int ans = dp[m];
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}