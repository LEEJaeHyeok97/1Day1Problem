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
        for(int i = 0; i < n; i++) {
            dp[i] = 0;
        }
        dp[0] = 0;
        initialize();
        if(n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(dp[n - 1]);
    }

    static void initialize() {
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(i <= j + arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] == 0) {
                return;
            }
        }
    }
}