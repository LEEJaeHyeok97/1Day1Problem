import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();

        char[] cArr = s.toCharArray();
        int[][][] dp = new int[N+1][K+1][2];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        dp[0][0][0] = 0;
        for(int i = 1; i <= N; i++) {
            int crystal = (cArr[i-1] == 'L') ? 0 : 1;
            for(int j = 0; j <= K; j++) {
                for(int k = 0; k < 2; k++) {
                    int gain = (crystal == k) ? 1 : 0;

                    if(dp[i - 1][j][k] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + gain);
                    }

                    if(j >= 1 && dp[i-1][j-1][(k+1)%2] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][(k+1)%2] + gain);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j <= K; j++) {
                ans = Math.max(ans, dp[N][j][i]);
            }
        }

        System.out.println(ans);
    }
}