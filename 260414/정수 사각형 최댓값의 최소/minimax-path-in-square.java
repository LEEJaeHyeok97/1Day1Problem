import java.util.Scanner;
public class Main {

    static int n;

    static int[][] dp;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dp = new int[n][n];
        dp[0][0] = matrix[0][0];

        initialize();
        System.out.println(dp[n-1][n-1]);
    }

    static void initialize() {
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(matrix[i][0], dp[i - 1][0]);
        }

        for(int j = 1; j < n; j++) {
            dp[0][j] = Math.max(matrix[0][j], dp[0][j - 1]);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(matrix[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
    }
}