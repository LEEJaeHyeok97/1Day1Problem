import java.util.Scanner;
public class Main {
    static long[][] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new long[n + 1][10];
        initialize();

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j >= 1 && j < 9) {
                    dp[i][j] += (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % (1000000000 + 7);
                }
                else if(j == 0) {
                    dp[i][j] += dp[i-1][j + 1]% (1000000000 + 7);
                }
                else if(j == 9) {
                    dp[i][j] += dp[i-1][j - 1]% (1000000000 + 7);
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 10; i++) {
            ans += (dp[n][i] % (1000000000 + 7));
        }

        System.out.println(ans % (1000000000 + 7));
    }

    static void initialize() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                dp[i][j] = 0;
            }
        }

        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        dp[1][0] = 0;
    }
}