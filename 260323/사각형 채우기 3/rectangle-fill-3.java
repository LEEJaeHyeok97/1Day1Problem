import java.util.Scanner;

// 2 * dp[i-1]
// 3 * dp[i - 2]
// 2 * dp[i - 3]
// 2 * dp[i - 4]
public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] memo = new long[1001];
        memo[0] = 1;
        memo[1] = 2;
        for(int i = 2; i <= n; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 2] * 3) % MOD;
            for(int j = i - 3; j >= 0; j--) {
                memo[i] = (memo[i] + memo[j] * 2) % MOD;
            }
        }
        
        System.out.println(memo[n]);
    }
}