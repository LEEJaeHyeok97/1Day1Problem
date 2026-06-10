import java.util.Scanner;
public class Main {

    static void initialize() {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0; // R과 B를 한개도 선택하지 않은 경우.
    }

    static int n;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] red = new int[2*n + 1];
        int[] blue = new int[2*n + 1];
        for (int i = 0; i < 2 * n; i++) {
            red[i + 1] = sc.nextInt();
            blue[i + 1] = sc.nextInt();
        }
        dp = new int[n + 1][n + 1];
        initialize();

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) continue;
                // 빨간 카드를 선택했을 때
                if(i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + red[i + j]);
                }

                // 파란 카드를 선택했을 때
                if(j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + blue[i + j]);
                }
            }
        }

        int ans = dp[n][n];
        System.out.println(ans);
    }
}