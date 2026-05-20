import java.util.*;

// n개의 동전의 종류가 주어졌을 때, 금액 m을 거슬러 주기 위한 최대 동전의 수를 계산
// 같은 종류의 동전을 여러 번 가능
public class Main {

    static final int MIN_NUM = Integer.MIN_VALUE;
    static int n, m;

    static int[] coin;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp = new int[m + 1];
        for(int i = 0; i <= m; i++) {
            dp[i] = MIN_NUM;
        }

        dp[0] = 0;
        for(int i = 1; i < m + 1; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coin[j] >= 0) {
                    if(dp[i - coin[j]] != MIN_NUM) {
                        dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
                    }
                }
            }
        }

        int ans = dp[m];
        if(ans == MIN_NUM) ans = -1;
        System.out.println(ans);
    }
}