import java.util.Scanner;

// 1. 카드 대결: 자신의 카드가 상대방의 카드보다 작다면, 그 카드에 적혀있는 점수만큼
// 점수를 얻고 카드의 번호가 작은 사람의 카드를 버립니다. 
// 둘의 카드가 같다면, 두 명 모두 점수를 얻지 못하며 둘의 카드를 버린다.

// 2. 카드 버리기: 두 플레이어는 서로의 카드르 버립니다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i] > b[j]) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + b[j]);
                } else if(a[i] < b[j]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i+1][j+1], dp[i][j]);
                }

                dp[i + 1][j + 1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
        }

        int ans = 0;                              // 점수는 음수가 안 되므로 0이 바닥
        for (int j = 0; j <= n; j++) ans = Math.max(ans, dp[n][j]);
        for (int i = 0; i <= n; i++) ans = Math.max(ans, dp[i][n]);
        System.out.println(ans);
    }
}