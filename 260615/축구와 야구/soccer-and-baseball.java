import java.util.Scanner;

// 축구 팀, 야구 팀
// 두 팀의 능력의 합이 최대가 되도록하는 N명의 학생들을 축구팀, 야구팀으로 선발
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soccer = new int[N];
        int[] baseball = new int[N];
        for (int i = 0; i < N; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }

        int[][][] dp = new int[N + 1][12][10];
        for(int[][] a : dp) {
            for(int[] b : a) {
                for(int c : b) {
                    c = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= 11; j++) {
                for(int k = 0; k <= 9; k++) {
                    // if (dp[i][j][k] == Integer.MIN_VALUE) continue;
                    if(i + 1 <= N) {
                        dp[i + 1][j][k] = Math.max(dp[i+1][j][k], dp[i][j][k]);
                    }
                    if(i + 1 <= N && j + 1 < 12) {
                        dp[i + 1][j + 1][k] = Math.max(dp[i+1][j + 1][k], dp[i][j][k] + soccer[i]);
                    }
                    if(i + 1 <= N && k + 1 < 10) {
                        dp[i + 1][j][k + 1] = Math.max(dp[i+1][j][k + 1], dp[i][j][k] + baseball[i]);
                    }
                }
            }
        }

        System.out.println(dp[N][11][9]);
    }
}