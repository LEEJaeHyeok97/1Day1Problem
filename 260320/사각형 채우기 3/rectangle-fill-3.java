import java.util.Scanner;

// 2 * dp[i-1]
// 3 * dp[i - 2]
// 2 * dp[i - 3]
// 2 * dp[i - 4]
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] memo = new int[1001];
        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 7;
        memo[3] = 22;
        for(int i = 4; i <= n; i++) {
            memo[i] = (memo[i-4] * 2) + (memo[i-3] * 2) + (memo[i-2] * 3) + (memo[i-1] * 2);
        }
        
        System.out.println(memo[n]);
    }
}