import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] prefixSum = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            prefixSum[0][i] = 0;
            prefixSum[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                prefixSum[i][j] = arr[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n - k + 1; i++) {
            for(int j = 1; j <= n - k + 1; j++) {
                int value = prefixSum[i+k-1][j+k-1] + prefixSum[i-1][j-1] - prefixSum[i+k-1][j-1] - prefixSum[i-1][j+k-1];
                ans = Math.max(ans, value);
            }
        }

        System.out.println(ans);
    }
}