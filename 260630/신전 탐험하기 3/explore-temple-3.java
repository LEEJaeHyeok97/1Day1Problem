import java.util.Scanner;

// 신전은 N층 
// 각 층은 1~M번 방 존재
// 직전층의 방번호를 다음 층에서 한번 더 들어가면 쫓겨난다. 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N + 1][M + 1];
        for(int i = 1; i <= M; i++) {
            dp[1][i] = a[0][i - 1];
        }

        for(int i = 2; i <= N; i++) {
            for(int k = 1; k <= M; k++) {
                for(int j = 1; j <= M; j++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + a[i-1][j-1]);
                }
            }
        }

        // for(int i = 0; i <= N; i++) {
        //     for(int j = 0; j <= M; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        int ans = 0;
        for(int i = 1; i < M; i++) {
            ans = Math.max(ans, dp[N][i]);
        }

        System.out.println(ans);
    }
}