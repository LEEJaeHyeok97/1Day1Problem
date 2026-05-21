import java.util.Scanner;

// N인 막대기. 최대 수익.
public class Main {

    static int n;
    static int[] profit;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(j - i >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - (i + 1)] + profit[i]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= n; i++) 
            ans = Math.max(ans, dp[i]);
        
        System.out.println(ans);
    }
}