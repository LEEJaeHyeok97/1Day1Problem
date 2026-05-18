import java.util.Scanner;
public class Main {

    static int n, m;

    static int[] arr; 
    static int[] dp;// 원소 길이를 담는다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        dp = new int[m + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j - arr[i] >= 0) {
                    if(dp[j - arr[i]] == Integer.MAX_VALUE)
                        continue;
                    
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        int ans = dp[m];
        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }
}