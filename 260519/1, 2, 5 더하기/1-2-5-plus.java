import java.util.Scanner;
public class Main {
    static int n;

    static int[] nums = {1, 2, 5};
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n + 1];

        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                if(i - nums[j] >= 0) {
                    dp[i] = (dp[i] + dp[i - nums[j]])  % 10007;
                }
            }
        }

        System.out.println(dp[n]);
    }
}