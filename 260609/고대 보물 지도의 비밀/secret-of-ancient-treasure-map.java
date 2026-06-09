import java.util.Scanner;

// n개의 숫자가 일렬로, 원하는 만큼 연속되게 선택할 수 있음.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(arr[i-1] < 0) {
                    if(j > 0 && dp[i-1][j-1] != Integer.MIN_VALUE) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i - 1]);
                    }
                    if(j == 1) {
                        dp[i][j] = Math.max(arr[i - 1] , dp[i][j]);
                    }
                }
                else {
                    if(dp[i-1][j] != Integer.MIN_VALUE) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + arr[i - 1]);
                    }
                    if(j == 0) {
                        dp[i][j] = Math.max(arr[i - 1] , dp[i][j]);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(i == 0 && j == 0) continue;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        if(ans == Integer.MIN_VALUE) {
            for(int i = 0; i < N; i++) {
                ans = Math.max(ans, arr[i]);
            }
        }
        System.out.println(ans);
    }
}