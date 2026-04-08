import java.util.Scanner;

public class Main {

    static int[][] matrix;
    static int[][] dp;
    static int n; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
    
        dp = new int[n][n];

        initialize();
        System.out.println(dp[n - 1][0]);
    }

    static void initialize() {
        dp[0][n-1] = matrix[0][n-1];

        for(int i = n - 2; i >= 0; i--) {
            dp[0][i] = dp[0][i + 1] + matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + matrix[i][n - 1];
        }

        for(int i = 1; i <= n - 1; i++) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + matrix[i][j];
            }
        }
    }
}