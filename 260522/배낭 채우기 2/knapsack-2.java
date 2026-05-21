import java.util.*;

// n개의 보석. 무게의 합이 m이 넘지 않도록 가치의 합은 최대가 되도록.
public class Main {

    static int n, m;

    static int[] weight;
    static int[] value;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 보석의 개수
        m = sc.nextInt(); // 무게의 합
        weight = new int[n];
        value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        dp = new int[m + 1];
        for(int i = 0; i <= m; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - weight[j] >= 0) {
                    if(dp[i - weight[j]] != Integer.MIN_VALUE) {
                        dp[i] = Math.max(dp[i], dp[i-weight[j]] + value[j]);
                    }
                }
            }
        }
        // for(int i = 0; i <= m; i++) {
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        int ans = 0;
        for(int i = 0; i <= m; i++)
            ans = Math.max(ans, dp[i]);
        System.out.println(ans);
    }
}