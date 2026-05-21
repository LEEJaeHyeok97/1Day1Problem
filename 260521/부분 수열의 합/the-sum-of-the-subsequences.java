import java.util.Scanner;

// n개의 원소 수열 A. 부분 수열 내 원소의 합이 M이 되는 경우가 있는지 판단하는 프로그램
public class Main {
    static final int MAX_M = 10000;
    static final int MAX_N = 100;

    static int n, m;

    static int[] arr = new int[MAX_N + 1];

    static boolean[][] dp = new boolean[MAX_N + 1][MAX_M + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                // i번 수를 선택하여 합이 j가 된 경우
                if(j >= arr[i] && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;
                
                // i번 수를 선택하지 않고 합이 j가 된 경우
                if(dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        if(dp[n][m])
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}