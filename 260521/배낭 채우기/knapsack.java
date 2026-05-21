import java.util.Scanner;

// N개의 보석 정보. 보석을 적절하게 골라 무게의 합이 M이 넘지 않도록 하면서 가치의
// 합은 최대가 되도록 하는 프로그램.
// 1, 2번
public class Main {
    
    static int n, m;

    static int[] w;
    static int[] v;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        dp = new int[m + 1];
        for(int i = 0; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = m; j > 0; j--) {
                if(j - w[i] >= 0) {
                    if(dp[j - w[i]] != Integer.MIN_VALUE) {
                        dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}