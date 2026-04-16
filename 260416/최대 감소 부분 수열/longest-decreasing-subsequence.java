import java.util.Scanner;
public class Main {

    static int n;

    static int[] arr;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[n];
        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    static void initialize() {
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }
    }
}