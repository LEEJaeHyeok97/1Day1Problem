import java.util.Scanner;

// 신전은 N층으로 이루어져 있다. 
// 각 층은 왼쪽, 가운데, 오른쪽 세 개의 방이 있다.
// 바로 직전 층에서 들어갔던 방향의 방을 한번 더 들어가면, 쫓겨난다.
// 1층부터 시작해서 N층까지 차례대로 올라가면서 쫓겨나지 않고 최대한 많은 보물을 가져가는
// 남우가 가져갈 수 있는 보물의 최대 개수를 구하는 프로그램을 작성.
public class Main {

    static int N;
    static int[][] data;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        data = new int[N][3];
        for (int i = 0; i < N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }

        dp = new int[N + 1][3];
        initialize();

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + data[i - 1][j]);
                }
            }
        }

        // for(int i = 0; i <= N; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[N][i]);
        }

        System.out.println(answer);
    }

    static void initialize() {
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i = 0; i < 3; i++) {
            dp[1][i] = data[0][i];
        }
    }
}