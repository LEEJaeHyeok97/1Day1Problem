import java.util.Scanner;

// 매일 각 사람의 업무량을 평가한다. 
// T를 총합 세번 이상 받았거나, B를 연속 세번 받은 사람은 해고.
// 총 N일을 살아남기 위해서 만들 수 있는 N자리의 평가 문자열의 가짓수를
// 10^9 + 7로 나눈 나머지를 구하세요.
public class Main {
    static final int MOD = 1000000007;
    static final int MAXN = 1005;
    static int n;
    static int[][][] dp = new int[MAXN][5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // i는 몇 번째 날, j는 지금까지 받은 T의 횟수, k는 연속된 B의 횟수
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        dp[1][0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    dp[i + 1][j + 1][0] = (dp[i + 1][j + 1][0] + dp[i][j][k]) % MOD;
                    dp[i + 1][j][0] = (dp[i + 1][j][0] + dp[i][j][k]) % MOD;
                    dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + dp[i][j][k]) % MOD;
                }
            }
        }

        int ans = 0;
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
                ans = (ans + dp[n][j][k]) % MOD;
            }
        }

        System.out.println(ans);
    }
}