import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n];
        int[] time = new int[n];

        int total_exp = 0;
        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            total_exp += exp[i];
            time[i] = sc.nextInt();
        }

        int[] dp = new int[total_exp + 1];
        for(int i = 0; i < total_exp + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = total_exp; j >= 0; j--) {
                if(j - exp[i] >= 0) {
                    if(dp[j - exp[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - exp[i]] + time[i]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = m; i < total_exp + 1; i++) {
            if(dp[i] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[i]);
            }
        }

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
}