import java.util.Scanner;

// N개의 정수, 연속한 부분 수열에 속한 원소들의 합이 최대가 될 때의 값을 출력.
// 부분 수열은 최소 한 개 이상의 원소를 포함합니다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        // for(int i = 1; i <= n; i++) {
        //     System.out.print(dp[i] + " ");
        // }

        System.out.println(ans);
    }
}