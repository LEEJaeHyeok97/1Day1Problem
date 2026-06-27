import java.util.Scanner;

// 직전 층과 같은 방을 한번 더 들어가면 쫓겨난다.
// 꼭대기 층인 N층에 들어갔던 방이 1층에 들어갔던 방과 같을 경우 쫓겨난다.
// 1~N층까지 최대한 많은 보물을 가져가는 프로그램.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int[][][] dp = new int[n + 1][3][3];
        for(int i = 0; i < 3; i++) {
            dp[1][i][i] = arr[0][i];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(k == j) continue;
                    for(int s = 0; s < 3; s++) {
                        if(s == j && i == n) continue;
                        dp[i][j][s] = Math.max(dp[i][j][s], dp[i - 1][k][s] + arr[i - 1][j]);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                ans = Math.max(ans, dp[n][i][j]);
            }
        }

        System.out.println(ans);
    }
}